public class Query {
	private String[] query;
	public String [][] table = null;
	private String path;

	public Query(String path) {
		this.path = path;
	}
	
	public boolean setSQL(String queryP){
		query = queryP.split("[ (),]+");
		return mange(query);
	}

	private boolean mange(String[] query) {
		switch (query[0]) {
		case "CREATE":
			create(query);
			break;
		case "INSERT":
			insert(query);
			break;
		case "UPDATE":
			update(query);
			break;
		case "SELECT":
			select(query);
			break;
		case "DELETE":
			delete(query);
			break;
		default:
			return goToHell();
		}
		return true;
	}

	private boolean goToHell() {
		// TODO Auto-generated method stub

		System.out.println("ektb sa7 ya 7mar");
		return false;
	}

	private void create(String[] query) {
		String[] columns = getCreateColumns(query);
		String[] tyeps = getCreateTypes(query);
		// table = table.create(cretPath(query[2]),columns,types);
	}

	private String[] getCreateColumns(String[] query) {
		String[] columns = new String[(query.length - 3) / 2];
		for (int i = 3; i < columns.length; i += 2) {
			columns[i - 3] = query[i];
		}
		return columns;
	}

	private String[] getCreateTypes(String[] query) {
		String[] tyeps = new String[(query.length - 3) / 2];
		for (int i = 3; i < tyeps.length; i += 2) {
			tyeps[i - 3] = query[i + 1];
		}
		return tyeps;
	}

	private void delete(String[] query) {
		if (query[1].matches("*")) {
			//table =  table.delete(cretPath(query[2]));
		} else {
			String[] columns = getDeleteColumns(query, 4);
			String[] values = getDeleteValues(query, 4);

			// table = table.delete(cretPath(query[2]),columns,values);
		}

	}

	private String[] getDeleteColumns(String[] query, int j) {
		String[] columns = new String[(query.length - j) / 2];
		for (int i = j; i < query.length; i += 2) {
			columns[i - j] = query[i];
		}
		return columns;
	}

	private String[] getDeleteValues(String[] query, int j) {
		String[] columns = new String[(query.length - j) / 2];
		for (int i = j; i < query.length; i += 2) {
			columns[i - j] = query[i + 1];
		}
		return columns;
	}

	private void insert(String[] query) {
		String[][] col = getInsertColumns(query);
		String[] columns = new String[col.length];
		String[] values = new String[col.length];
		for (int i = 0; i < values.length; i++) {
			columns[i] = col[i][0];
			values[i] = col[i][1];
		}
		// table = table.insert(cretPath(query[2]), columns,values);

	}

	private String[][] getInsertColumns(String[] query) {
		int j = 0;
		for (int i = 3; i < query.length; i++)
			if (query[i].matches("VALUES")) {
				j = i + 1;
				break;
			}
		String[][] columns = new String[query.length - j - 1][2];
		for (int i = 3; i < j - 1; i++, j++) {
			columns[i - 3][0] = query[i];
			columns[i - 3][1] = query[j];
		}
		return columns;
	}

	private void update(String[] query) {
		int check = checkQuery(query);
		if (check == 0) {
			String[] columns = getUpdateColumns(query);
			String[] values = getUpdateValues(query);
			// table = table.update(cretPath(query[1]), columns, values);
		} else {
			String[] where_columns = getUpdate_WhereColumns(query, check);
			String[] where_values = getUpdate_WhereValues(query, check);
			String[] columns = getUpdate_columns(query, check);
			String[] values = getUpdate_values(query, check);
			// table = table.update(cretPath(query[1]),
			// columns,values,where_columns,where_values);
		}
	}

	private String[] getUpdate_columns(String[] query, int check) {
		String[] columns = new String[(check - 3) / 2];
		for (int i = 3; i < check; i += 2) {
			columns[i - 3] = query[i];
		}
		return columns;
	}

	private String[] getUpdate_values(String[] query, int check) {
		String[] values = new String[(check - 3) / 2];
		for (int i = 4; i < check; i += 2) {
			values[i - 4] = query[i];
		}
		return values;
	}

	private String[] getUpdate_WhereColumns(String[] query, int check) {
		String[] columns = new String[(query.length - check + 1) / 2];
		for (int i = check + 1; i < query.length; i += 2) {
			columns[i - (check + 1)] = query[i];
		}
		return columns;
	}

	private String[] getUpdate_WhereValues(String[] query, int check) {
		String[] values = new String[(query.length - check + 1) / 2];
		for (int i = check + 2; i < query.length; i += 2) {
			values[i - (check + 2)] = query[i];
		}
		return values;
	}

	private String[] getUpdateColumns(String[] query) {
		String[] columns = new String[(query.length - 3) / 2];
		for (int i = 3; i < query.length; i += 2) {
			columns[i - 3] = query[i];
		}
		return columns;
	}

	private String[] getUpdateValues(String[] query) {
		String[] values = new String[(query.length - 3) / 2];
		for (int i = 4; i < query.length; i += 2) {
			values[i - 4] = query[i];
		}
		return values;
	}

	private int checkQuery(String[] query) {
		for (int i = 0; i < query.length; i++) {
			if (query[i].matches("WHERE"))
				return i;
		}
		return 0;
	}

	private void select(String[] query) {
		if (query.length == 4 && query[1].matches("*")) {
			// table = table.select(cretPath(query[3]));
		} else if (query[1].matches("*")) {
			String[] columns = getDeleteColumns(query, 5);
			String[] values = getDeleteValues(query, 5);
			// table = table.select(cretPath(query[3]),columns, values);
		} else {
			int where = checkQuery(query);
			if (where != 0) {
				String[] where_columns = getUpdate_WhereColumns(query, where);
				String[] where_values = getUpdate_WhereValues(query, where);
				String[] columns = getSelectColumns(query);
				//table =  table.select(cretPath(query[columns.length+2]), columns,
				// where_columns,where_values);
			} else {
				String[] columns = getInsert_Columns(query);
				// table = table.select(cretPath(query[columns.length+2]),columns);
			}
		}

	}

	private String[] getInsert_Columns(String[] query) {
		String [] columns = new String[query.length - 3];
		for (int i = 1; !query[i].matches("FROM"); i++) {
			columns[i-1] = query[i];
		}
		return columns;
	}

	private String[] getSelectColumns(String[] query) {
		int j = 0;
		for (int i = 0; i < query.length; i++) {
			if (query[i].matches("FROM")) {
				j = i - 1;
			}
		}
		String[] columns = new String[j];
		for (int i = 1; i < columns.length && !query[i].matches("FROM"); i++) {
			columns[i - 1] = query[i];
		}
		return columns;
	}
	
	private String cretPath(String tableName){
		return path + tableName+".xml";
	}
}
