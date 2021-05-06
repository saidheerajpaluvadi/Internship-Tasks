package sqlviewgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class will take the input and produces the required SQL view query.
 * 
 * @author Dheeraj
 *
 */
public class Main {

	/**
	 * {@code parentTable} will hold the parent table.
	 */
	private static ParentTable parentTable;
	/**
	 * {@code chilTables} list of child tables;
	 */
	private static List<Table> childTables;
	/**
	 * {@code scanner} used to get the input fields.
	 */
	private static Scanner scanner;

	/**
	 * main: take the input from user and generate the query using the
	 * {@link SQLViewGenerator} class.
	 * 
	 * @param args command line aruguments
	 */
	public static void main(String args[]) {

		try {
			scanner = new Scanner(System.in);

			inputParentTable();
			childTables = new ArrayList<Table>(parentTable.getNoOfChildren());
			for (int counter = 0; counter < parentTable.getNoOfChildren(); counter++)
				inputChildTable();

		} finally {
			scanner.close();
		}

		SQLViewGenerator sqlViewGenerator = new SQLViewGenerator();
		System.out.println(sqlViewGenerator.generateQuery(parentTable, childTables));
	}

	/**
	 * inputParentTable: It will take the input for parent table.
	 */
	private static void inputParentTable() {
		System.out.print("Enter the Parent table name: ");
		String parentTableName = scanner.nextLine();

		System.out.println("Enter the table columns:");
		List<String> parentColumnsList = new ArrayList<String>();
		while (true) {
			String inputColumnName = scanner.nextLine();
			if (inputColumnName.equals("end"))
				break;
			if (!inputColumnName.isBlank())
				parentColumnsList.add(inputColumnName);
		}

		while (true) {
			System.out.print("Enter No. of tables: ");
			int noOfTables = Integer.parseInt(scanner.nextLine());
			if (noOfTables > 0 && noOfTables < 4) {
				parentTable = new ParentTable(parentTableName, parentColumnsList, noOfTables);
				break;
			} else {
				System.out.println("Number of tables cannot exceed 3");
			}
		}

	}

	/**
	 * inputChildTable: It will take the input for child table.
	 */
	private static void inputChildTable() {
		System.out.print("Enter Table Name: ");
		String tableName = scanner.nextLine();
		List<String> columnsList = new ArrayList<String>();
		System.out.println("Enter the table columns:");
		while (true) {
			String inputColumnName = scanner.nextLine();
			if (inputColumnName.equals("end"))
				break;

			if (!inputColumnName.isBlank() && parentTable.hasColumn(inputColumnName))
				columnsList.add(inputColumnName);
			else {
				throw new RuntimeException("The column " + inputColumnName
						+ " is not allowed as it is not defined in parent table " + parentTable.getName() + "");
			}
		}

		childTables.add(new Table(tableName, columnsList));
	}

}
