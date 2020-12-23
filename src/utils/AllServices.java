package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/*
 * ����������
 */

public class AllServices {

	// �������ݿ�����
	public static Connection getDBConnection() {

		Connection conn = null;

		// ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ׼��url���û���������
			String url = "JDBC:mysql://localhost:3306/db_180110910439?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";

			// ��������
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// ��ӹ˿�
	public static void addCustomer(String telephone, String password) throws SQLException {

		// �����ݿ⽨������
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "insert into t_customer(cusPhone, cusPassword) values(?, ?)";
		ps = conn.prepareStatement(sqlStatement);

		ps.setString(1, telephone);
		ps.setString(2, password);

		// �����ݿⷢ��SQL���
		ps.executeUpdate();

		// �ͷ���Դ
		conn.close();
		ps.close();

	}

	// �û���¼
	public static boolean login(String telephone, String password, String flag) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			if ("customer".equals(flag)) {
				sqlStatement = "select * from t_customer where cusPhone=? and cusPassword=?";
				Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class),
						telephone, password);

				if (customer != null) {
					result = true;
				}
			} else {
				sqlStatement = "select * from t_administrator where admPhone=? and admPassword=?";
				Administrator administrator = runner.query(conn, sqlStatement,
						new BeanHandler<Administrator>(Administrator.class), telephone, password);

				if (administrator != null) {
					result = true;
				}
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// ��ӵ�¼��־
	public static void addLog(String telephone, String ipAddr) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "insert into t_log(telephone, ipAddress) values(?, ?)";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, telephone);
			ps.setString(2, ipAddr);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �û�����
	public static boolean findOne(String telephone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), telephone);

			if (customer != null) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// �û��������
	public static boolean updateCusPassword(String cusPhone, String newPassword) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			String sqlStatement = "update t_customer set cusPassword=? where cusPhone=?";

			// Ԥ�ö���
			PreparedStatement ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, newPassword);
			ps.setString(2, cusPhone);

			// ִ��sql��䣬����Ӱ������
			int res = ps.executeUpdate();

			if (res > 0) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// У���˺ź������Ƿ���Ч
	public static boolean verifyCusPhonePassword(String cusPhone, String password) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=? and cusPassword=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), cusPhone,
					password);

			if (customer != null) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// ���濪����Ϣ�����û����״̬���и��ģ���Ϊ�ɽ��л�����
	public static void saveOpenAccInfo(String cusPhone, String cusName, String cusIDNum, String cusCCNum,
			String cusPhoto) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "update t_customer set cusName=?, cusIDNum=?, cusCCNum=?, cusStatus=? , cusPhoto=? where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusName);
			ps.setString(2, cusIDNum);
			ps.setString(3, cusCCNum);
			ps.setInt(4, 1);// �����û�״̬
			ps.setString(5, cusPhoto);
			ps.setString(6, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �ж��û��Ƿ񿪻�
	public static boolean verifyCusStatus(String cusPhone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), cusPhone);

			if (customer.getCusStatus() == 1) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// �û�ɾ��
	public static void deleteCus(String cusPhone) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatementCus = "delete from t_customer where cusPhone=?";
		String sqlStatementPur = "delete from t_purchaserec where cusPhone=?";
		String sqlStatementSelf = "delete from t_selfchosen where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatementCus);
			ps.setString(1, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			ps = conn.prepareStatement(sqlStatementPur);
			ps.setString(1, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			ps = conn.prepareStatement(sqlStatementSelf);
			ps.setString(1, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �������л���˾����Ϣ ��ҳ
	public static List<FundCompany> loadAllFundComInfo(int pageNo) {

		Connection conn = null;
		List<FundCompany> fundCompanies = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT * FROM t_fundcompany order by id limit " + ((pageNo - 1) * 10) + ", 10";

			fundCompanies = runner.query(conn, sqlStatement, new BeanListHandler<FundCompany>(FundCompany.class));

			conn.close();
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundCompanies;
	}

	// ͳ�Ʊ��е�����
	public static int countRec(String tableName) {

		Connection conn = null;
		DBRecCounterDto res = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT COUNT(*) as count from " + tableName;

			res = runner.query(conn, sqlStatement, new BeanHandler<DBRecCounterDto>(DBRecCounterDto.class));

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res.getCount();
	}

	// ��ȡ���л��������
	public static List<Fund> loadAllFundInfo() {

		Connection conn = null;
		List<Fund> funds = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT * from t_fund ORDER BY fundYearYields desc, fundSeasonYields DESC";

			funds = runner.query(conn, sqlStatement, new BeanListHandler<Fund>(Fund.class));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funds;
	}

	// ��ȡ���л����������
	public static List<FundManager> loadAllFundManagerInfo() {

		Connection conn = null;
		List<FundManager> fundManagers = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT * from t_fundmanager";

			fundManagers = runner.query(conn, sqlStatement, new BeanListHandler<FundManager>(FundManager.class));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundManagers;
	}

	// ��ȡ���л���˾������
	public static List<FundCompany> loadAllFundCompanyInfo() {

		Connection conn = null;
		List<FundCompany> fundCompanies = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT * from t_fundcompany";

			fundCompanies = runner.query(conn, sqlStatement, new BeanListHandler<FundCompany>(FundCompany.class));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundCompanies;
	}

	// ��ȡ������ѡ���������
	public static List<SelfChosenDto> loadAllSelfChosenInfo(String tel) {

		Connection conn = null;
		List<SelfChosenDto> selfChosens = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

			String sqlStatement = "SELECT t_selfchosen.fundCode, t_fund.fundName, t_fund.fundNAV, t_fund.fundYearYields, t_fund.fundType, t_fund.fundInvestType, t_fund.fundBuyStatus FROM t_selfchosen LEFT JOIN t_fund ON t_selfchosen.fundCode = t_fund.fundCode WHERE t_selfchosen.cusPhone = ? AND t_fund.fundStatus = 1";

			selfChosens = runner.query(conn, sqlStatement, new BeanListHandler<SelfChosenDto>(SelfChosenDto.class),
					tel);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return selfChosens;
	}

	// �û�����
	public static Customer findExactCus(String telephone) {

		Connection conn = null;
		Customer customer = null;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=?";
			customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), telephone);

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	// ͳ��ĳһ�û�����Ļ�������
	public static int calFundNumForCus(String telephone) {

		Connection conn = null;
		int fundNum = 0;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT * from t_purchaserec where cusPhone = ?";
			List<PurchaseRec> purchaseRec = runner.query(conn, sqlStatement,
					new BeanListHandler<PurchaseRec>(PurchaseRec.class), telephone);

			if (purchaseRec.size() > 0)
				fundNum = purchaseRec.size();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundNum;
	}

	// ͳ��ĳһ�û���������л�����ܶ�
	public static double calFundAssetsTotalForCus(String telephone) {

		Connection conn = null;
		double fundTotal = 0;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT buyShare, fundNAV FROM (SELECT cusPhone, buyShare, fundNAV FROM t_purchaserec AS p LEFT JOIN t_fund AS f on p.fundCode = f.fundCode) AS t_new WHERE cusPhone = ?";
			List<CalFundAssetsDto> calFundAssetsDto = runner.query(conn, sqlStatement,
					new BeanListHandler<CalFundAssetsDto>(CalFundAssetsDto.class), telephone);

			if (calFundAssetsDto != null) {
				for (CalFundAssetsDto item : calFundAssetsDto) {
					fundTotal += item.getFundNAV() * item.getBuyShare();
				}
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundTotal;
	}

	// ���ݻ����������ѯ����
	public static Fund getFundByCode(String fundCode) {

		Connection conn = null;
		Fund fund = null;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT * from t_fund where fundCode = ?";
			fund = runner.query(conn, sqlStatement, new BeanHandler<Fund>(Fund.class), fundCode);

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fund;
	}

	// �û����п��Ÿ���
	public static boolean updateCusTelCCNum(String cusPhone, String newCCNum) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			String sqlStatement = "update t_customer set cusCCNum=? where cusPhone=?";

			// Ԥ�ö���
			PreparedStatement ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, newCCNum);
			ps.setString(2, cusPhone);

			// ִ��sql��䣬����Ӱ������
			int res = ps.executeUpdate();

			if (res > 0) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// ��ӵ���ѡ
	public static boolean addToSelfChosen(String telephone, String fundCode) {

		boolean result = false;

		// �������ݿ�����
		Connection conn = getDBConnection();
		QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean

		// ���ȼ���û��Ƿ��Ѿ�����˸û���
		String sqlStatementCheck = "select * from t_selfchosen where cusPhone=? and fundCode=?";

		try {
			List<SelfChosen> selfChosens = runner.query(conn, sqlStatementCheck,
					new BeanListHandler<SelfChosen>(SelfChosen.class), telephone, fundCode);

			if (selfChosens.size() == 0) {
				// ��дSQL���
				String sqlStatement = "insert into t_selfchosen(cusPhone, fundCode) values(?, ?)";
				// ��ȡ���������ݿⷢ��SQL����statement
				PreparedStatement ps = null;
				ps = conn.prepareStatement(sqlStatement);
				ps.setString(1, telephone);
				ps.setString(2, fundCode);

				// �����ݿⷢ��SQL���
				ps.executeUpdate();
				result = true;

				ps.close();
			}

			// �ͷ���Դ
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

	// �û��������
	public static boolean buyFund(String cusPhone, String fundCode, String fundName, int buyShare) {

		boolean result = false;

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "insert into t_purchaserec(cusPhone, fundCode, fundName, buyShare) values(?, ?, ?, ?)";
		// insert into t_purchaserec (cusPhone, fundCode, fundName, buyShare) values(?,
		// ?, ?, ?) on duplicate key update buyShare = buyShare + 1;

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusPhone);
			ps.setString(2, fundCode);
			ps.setString(3, fundName);
			ps.setInt(4, buyShare);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();
			result = true;

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

	// ���ݻ�����������ѯ����
	public static Fund getFundByName(String fundName) {

		Connection conn = null;
		Fund fund = null;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT * from t_fund where fundName = ?";
			fund = runner.query(conn, sqlStatement, new BeanHandler<Fund>(Fund.class), fundName);

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fund;
	}

	// ���ݹ�˾��������ѯ����˾
	public static FundCompany getComByName(String comName) {

		Connection conn = null;
		FundCompany fundCompany = null;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT * from t_fundcompany where comName = ?";
			fundCompany = runner.query(conn, sqlStatement, new BeanHandler<FundCompany>(FundCompany.class), comName);

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundCompany;
	}

	// ������������ѯ������
	public static FundManager getmanByName(String manName) {

		Connection conn = null;
		FundManager fundManager = null;
		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
			String sqlStatement;

			sqlStatement = "SELECT * from t_fundmanager where manName = ?";
			fundManager = runner.query(conn, sqlStatement, new BeanHandler<FundManager>(FundManager.class), manName);

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fundManager;
	}
}
