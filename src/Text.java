

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class Text {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu();
		int choose = 10;
		while(true){
			System.out.println("�����������蹦��:");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				addPerson();
				break;
			case 2:
				updatePerson();
				break;
			case 3:
				System.out.println("������Ӣ������:");
				String name = sc.next();
				deletePerson1(name);
				break;
			case 4:
				System.out.println("������Ӣ�۱��:");
				int id = sc.nextInt();
				deletePerson(id);
				break;
			case 5:
				System.out.println("������Ӣ�۱��:");
				int idd = sc.nextInt();
				findAllPerson1(idd);
				break;
			case 6:
				findAllPerson();
				break;

			case 0:
				System.exit(0);
				break;
			}
		}
	}

	private static void Menu() {
		System.out.println("1:�������");
		System.out.println("2:�޸�����");
		System.out.println("3:��������ɾ��");
		System.out.println("4:����idɾ��");
		System.out.println("5:����id��ѯ");
		System.out.println("6:��ѯ����Ӣ��");
		System.out.println("0:�˳�");
	}

	// ��ӷ��� Ԥ���� ok
	private static void addPerson() {
		// ���
		Scanner sc = new Scanner(System.in);
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql = "insert into person(id,name,username,password,age,des,hight) values(?,?,?,?,?,?,?)";
		System.out.println("��������");
		int id = sc.nextInt();
		System.out.println("����������");
		String name = sc.next();
		System.out.println("����username");
		String username = sc.next();
		System.out.println("����password");
		String password = sc.next();
		System.out.println("��������");
		int age = sc.nextInt();
		System.out.println("�������");
		String des = sc.next();
		System.out.println("�������");
		double weight = sc.nextDouble();
		int update = jt.update(sql, id, name, username, password, age,
				des, weight);
		System.out.println("�޸���Ϊ:"+update);
	}

	// �޸ķ��� Ԥ���� ok
	private static void updatePerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ӣ�۱��:");
			int id = sc.nextInt();
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
		
		while(true){
			System.out.println("2:�޸�name");
			System.out.println("3:�޸�username");
			System.out.println("4:�޸�password");
			System.out.println("5:�޸�age");
			System.out.println("6:�޸�des");
			System.out.println("7:�޸�hight");
			int x = sc.nextInt();
			switch (x) {
			case 1:
				
				break;
			case 2:
				System.out.println("�������µ�name");
				String name = sc.next();
				int update2 = jt.update(" update person set name = ? where id = ? ",
						name, id);
				System.out.println("�޸���Ϊ:"+update2);
				break;
			case 3:
				System.out.println("�������µ�username");
				String username = sc.next();
				int update3 = jt.update(" update person set username = ? where id = ? ",
						username, id);
				System.out.println("�޸���Ϊ:"+update3);
				break;
			case 4:
				System.out.println("�������µ�password");
				String password = sc.next();
				int update4 = jt.update(" update person set password = ? where id = ? ",
						password, id);
				System.out.println("�޸���Ϊ:"+update4);
				break;
			case 5:
				System.out.println("�������µ�age");
				int age = sc.nextInt();
				int update5 = jt.update(" update person set age = ? where id = ? ",
						age, id);
				System.out.println("�޸���Ϊ:"+update5);
				break;
			case 6:
				System.out.println("�������µ�username");
				String des = sc.next();
				int update6 = jt.update(" update person set des = ? where id = ? ",
						des, id);
				System.out.println("�޸���Ϊ:"+update6);
				break;
			case 7:
				System.out.println("�������µ�username");
				double hight = sc.nextDouble();
				int update7 = jt.update(" update person set hight = ? where id = ? ",
						hight, id);
				System.out.println("�޸���Ϊ:"+update7);
				break;

			default:
				break;
			}
		}
		
		
	}

	// ɾ�� ok
	private static void deletePerson1(String x) {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("  delete from person where name = ?", x);
		System.out.println("�޸���Ϊ:"+update);
	}

	// ɾ�� ok
	private static void deletePerson(int x) {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("  delete from person where id = ?", 2);
		System.out.println("�޸���Ϊ:"+update);
	}

	// ���ҵ�����Ϣ
	private static void findAllPerson1(int x) {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

		String sql = "select * from person where id = ?";
		List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(
				Person.class), x);

		for (Person person : list) {
			System.out.println(person);
		}
	}

	// ����ȫ����Ϣ
	private static void findAllPerson() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

		String sql = "select * from person";
		List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(
				Person.class));

		for (Person person : list) {
			System.out.println(person);
		}
	}
}
