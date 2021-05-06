package sqlviewgenerator;

import java.util.List;

/**
 * ParentTable class indicates a table with specified number of child tables.
 * 
 * @author Dheeraj
 *
 */
public class ParentTable extends Table {
	/**
	 * {@code noOfChildren} indicates the number of child tables.
	 */
	private int noOfChildren;

	/**
	 * 
	 * Constructs the {@code ParentTable} object with given table name, List of
	 * columns and the number of children
	 * 
	 * @param name         the table name.
	 * @param columnList   the list of columns in the table.
	 * @param noOfChildren the number of child tables.
	 */
	public ParentTable(String name, List<String> columnList, int noOfChildren) {
		super(name, columnList);
		this.noOfChildren = noOfChildren;
	}

	/**
	 * getNoOfChildren: return the number of child tables.
	 * 
	 * @return the number of child tables
	 */
	public int getNoOfChildren() {
		return noOfChildren;
	}

}
