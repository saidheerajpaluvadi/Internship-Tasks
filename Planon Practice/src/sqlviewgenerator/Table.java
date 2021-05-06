package sqlviewgenerator;

import java.util.Collections;
import java.util.List;

/**
 * Table class is used to handle the database table.
 * 
 * @author Dheeraj
 *
 */
public class Table {
	/**
	 * {@code name} represents the table name.
	 */
	private String name;
	/**
	 * {@code columnList} represents the list of columns.
	 */
	private List<String> columnList;

	/**
	 * Constructs the table object with given table name and the list of columns.
	 * 
	 * @param name       the table name.
	 * @param columnList the list of columns for a table.
	 */
	public Table(String name, List<String> columnList) {
		super();
		this.name = name;
		this.columnList = columnList;
	}

	/**
	 * getName: to get the name of the table.
	 * 
	 * @return the name of the table.
	 */
	public String getName() {
		return name;
	}

	/**
	 * getSortedColumnList: sort the {@code columnList} according to the column name
	 * 
	 * @return the list of columns in sorted order.
	 */
	public List<String> getSortedColumnList() {
		Collections.sort(columnList);
		return columnList;
	}

	/**
	 * hasColumn: is used to check whether the given {@code columnName} is present
	 * in the parent's column list.
	 * 
	 * @param columnName columnName to check.
	 * 
	 * @return true if {@code columnName} is present in thr parent's column list.
	 */
	public boolean hasColumn(String columnName) {
		return columnList.contains(columnName);
	}

}
