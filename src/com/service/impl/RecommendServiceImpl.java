package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BooksDAO;
import com.dao.FavDAO;
import com.dao.UsersDAO;
import com.entity.Books;
import com.entity.Fav;
import com.entity.Users;
import com.service.RecommendService;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
	@Autowired
	@Resource
	private FavDAO favDAO;
	// 注入DAO对象
	@Autowired
	@Resource
	private BooksDAO booksDAO;
	@Autowired
	@Resource
	private UsersDAO usersDAO;
	private String userid = "";
	// 相似用户集合
	private List<List<Object>> similarityUsers = null;
	// 推荐所有图书集合
	private List<String> targetRecommendObject = null;
	// 收藏过图书集合
	private List<String> commentedObject = null;
	// 用户在图书收藏集合中的位置
	private int targetUserIndex = 0;
	// 目标用户收藏过的图书
	private List<String> targetUserCommentedObject = null;

	private String[] books = null;

	@Override
	public List<Books> getRecommend(String userid) {
		this.userid = userid;
		// 建立用户数组 除了当前用户外 随机抽取9个用户
		// 理论上 用户越多收藏的图书越多 推荐的就越精确
		String[] users = new String[10];
		users[0] = this.userid;
		List<Users> usersList = this.usersDAO.getUsers(this.userid);
		System.out.println("users == > " + usersList.size());
		for (int i = 0; i < 9; i++) {
			int j = i + 1;
			int tbNum = usersList.size();
			if (i < tbNum) {
				users[j] = usersList.get(i).getUsersid();
			} else {
				users[j] = "0";
			}
		}
		List<Books> booksList = this.booksDAO.getAllBooks();
		this.books = new String[booksList.size()];
		for (int j = 0; j < booksList.size(); j++) {
			this.books[j] = booksList.get(j).getBooksid();
		}
		// 建立收藏二维数组 用户收藏了图书 1 未收藏 0 之后计算用户的相似度
		int[][] allUserObjects = new int[10][booksList.size()];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < booksList.size(); j++) {
				String booksid = this.books[j];
				Fav fav = new Fav();
				fav.setUsersid(users[i]);
				fav.setBooksid(booksid);
				List<Fav> favList = this.favDAO.getFavByCond(fav);
				if (favList.size() == 0) {
					allUserObjects[i][j] = 0;
				} else {
					allUserObjects[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < booksList.size(); j++) {
				if (j == booksList.size() - 1) {
					System.out.print(allUserObjects[i][j]);
				} else {
					System.out.print(allUserObjects[i][j] + " ,");
				}
			}
			System.out.println("");
		}
		this.targetUserCommentedObject = new ArrayList<String>();
		Fav fav = new Fav();
		fav.setUsersid(this.userid);
		List<Fav> histList = this.favDAO.getFavByCond(fav);
		for (int i = 0; i < histList.size(); i++) {
			// 转换目标用户图书收藏列表
			this.targetUserCommentedObject.add(histList.get(i).getFavid());
		}

		// 计算用户相似度，排序
		this.calcUserSimilarity(allUserObjects, booksList.size());
		// 计算图书推荐度，排序
		this.calcRecommendObjects(allUserObjects, booksList.size());
		// 处理推荐图书列表
		this.handleRecommendObject(allUserObjects, booksList.size());
		String rommendId = "";
		for (int i = 0; i < this.targetRecommendObject.size(); i++) {
			String item = this.targetRecommendObject.get(i);
			if (!commentedObject.contains(item)) {
				if (i == this.targetRecommendObject.size() - 1) {
					rommendId += item;
				} else {
					rommendId += item + ",";
				}
			}
		}
		String[] str = rommendId.split(",");
		List<Books> bookList = new ArrayList<Books>();
		if (!"".equals(rommendId)) {
			for (String x : str) {
				System.out.println(x);
				Books g = this.booksDAO.getBooksById(x);
				bookList.add(g);
			}
		} else {
			bookList = this.booksDAO.getHotBooks();
		}
		return bookList;
	}

	private void calcRecommendObjects(int[][] allUserObjects, int booksNum) {
		this.targetRecommendObject = new ArrayList<String>();
		List<List<Object>> recommendObjects = new ArrayList<List<Object>>();
		List<Object> recommendObject = null;
		double recommdRate = 0, sumRate = 0;
		for (int i = 0; i < booksNum; i++) {
			recommendObject = new ArrayList<Object>();
			recommendObject.add(i);
			recommdRate = allUserObjects[Integer.parseInt(similarityUsers.get(0).get(0).toString())][i]
					* Double.parseDouble(similarityUsers.get(0).get(1).toString())
					+ allUserObjects[Integer.parseInt(similarityUsers.get(1).get(0).toString())][i]
							* Double.parseDouble(similarityUsers.get(1).get(1).toString());
			recommendObject.add(recommdRate);
			recommendObjects.add(recommendObject);
			sumRate += recommdRate;
		}
		System.out.println("sumRate  == > " + sumRate / booksNum);
		recommendObjects = compare(recommendObjects);
		for (List<Object> tList : recommendObjects) {
			System.out.println(tList.get(1));
		}
		// 大于平均推荐度的图书才有可能被推荐
		for (int i = 0; i < recommendObjects.size(); i++) {
			List<Object> item = recommendObjects.get(i);
			if (Double.parseDouble(item.get(1).toString()) > sumRate / booksNum) { // 大于平均推荐度的图书才有可能被推荐
				System.out.println("books= = >" + books[Integer.parseInt(item.get(0).toString())]);
				this.targetRecommendObject.add(books[Integer.parseInt(item.get(0).toString())]);
			}
		}
		for (String x : this.targetRecommendObject) {
			System.out.println("x= = >" + x);
		}
	}

	/**
	 * 把推荐列表中用户已经收藏过的图书剔除
	 */
	private void handleRecommendObject(int[][] allUserObjects, int booksNum) {
		int[] user2hist = new int[booksNum];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < booksNum; j++) {
				user2hist[j] = allUserObjects[i][j];
			}
		}
		commentedObject = new ArrayList<String>();
		for (int i = 0; i < user2hist.length; i++) {
			if (allUserObjects[0][i] != 0) {
				commentedObject.add(books[i]);
			}
		}
	}

	/**
	 * 获取两个最相似的用户
	 */
	private void calcUserSimilarity(int[][] allUserObjects, int booksNum) {
		int[] user2hist = new int[booksNum];
		List<List<Object>> tmpList = new ArrayList<List<Object>>();

		for (int i = 0; i < 10; i++) {
			if (i == targetUserIndex) {
				for (int j = 0; j < booksNum; j++) {
					user2hist[j] = allUserObjects[i][j];
				}
				continue;
			}
			List<Object> userSimilarity = new ArrayList<Object>();
			int[] user1hist = new int[booksNum];
			for (int j = 0; j < booksNum; j++) {
				user1hist[j] = allUserObjects[i][j];

			}
			userSimilarity.add(i);
			userSimilarity.add(calcTwoUserSimilarity(user1hist, user2hist, booksNum));
			tmpList.add(userSimilarity);
		}
		this.similarityUsers = compare(tmpList);
	}

	/**
	 * 根据用户数据，计算用户相似度
	 * 
	 * @param user1hist
	 * @param user2hist
	 * @return
	 */
	private static double calcTwoUserSimilarity(int[] user1hist, int[] user2hist, int booksNum) {
		double sum = 0;
		for (int i = 0; i < booksNum; i++) {
			sum += Math.pow(user1hist[i] - user2hist[i], 2);
		}
		return Math.sqrt(sum);
	}

	/**
	 * 集合排序
	 */
	private static List<List<Object>> compare(List<List<Object>> tmpList) {
		for (int i = 0; i < tmpList.size(); i++) {
			for (int j = 0; j < tmpList.size() - i; j++) {
				List<Object> t1 = tmpList.get(i);
				List<Object> t2 = tmpList.get(j);
				if (Double.parseDouble("" + t1.get(1)) > Double.parseDouble("" + t2.get(1))) {
					List<Object> tmp = new ArrayList<Object>();
					tmp = t1;
					tmpList.set(i, t2);
					tmpList.set(j, tmp);
				}
			}
		}
		return tmpList;
	}

}
