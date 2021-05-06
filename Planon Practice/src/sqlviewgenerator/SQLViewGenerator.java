package sqlviewgenerator;

import java.util.List;

/**
 * SQLViewGenerator class is used to generate the sql query.
 * 
 * @author Dheeraj
 *
 */
public class SQLViewGenerator {

	/**
	 * generateQuery: generate the required sql query by using the parentTable and
	 * the list of childTables
	 * 
	 * @param parentTable holds the ParentTable object.
	 * @param childTables represents the list of child tables.
	 * 
	 * @return Sql view query
	 */
	public String generateQuery(ParentTable parentTable, List<Table> childTables) {
		StringBuilder result = new StringBuilder();
		result.append("CREATE OR REPLACE VIEW " + parentTable.getName().toUpperCase() + "\n" + "(\n");

		parentTable.getSortedColumnList().forEach((column) -> result.append("\t" + column + ",\n"));

		result.append(")\n");
		result.append("As\n");

		for (int index = 0; index < childTables.size(); index++) {
			Table childTable = childTables.get(index);
			List<String> childTableColumnList = childTable.getSortedColumnList();
			result.append("SELECT\n");

			parentTable.getSortedColumnList().forEach(column -> {
				if (childTableColumnList.contains(column))
					result.append("\t" + column + ",\n");
				else
					result.append("\tnull as " + column + ",\n");
			});

			result.append("FROM " + childTable.getName().toUpperCase() + "\n");
			if (index != childTables.size() - 1)
				result.append("UNION ALL\n");

		}

		return result.toString();
	}

}
