package gui;

	public interface XMLEngineInterface {
		public String[][] createTable(String tableName, String[] cols , String[] Types);	//To create the dataBase Table

		public String[][] insertElement( String tableName , String[] cols , String[] values ); //To insert new Element to the table
	
		public String[][] deleteTable(String tableName); //To delete existing Data from table
		public String[][] deleteTable(String tableName, String[] cols , String[] values); //To delete the row which have the given values in the specific coloms	
		public String[][] deleteByAttributeName(String tableName , String attributeName , String attributeValue); //To delete exist Element using the name of the attribute of the element
	
		public String[][] updateTable(String tableName, String[] cols , String[] values); //Will Update the entire colom with new value
		public String[][] updateTable(String tableName, String[] cols , String[] values , String[] whereCol ,String [] whereValue ); //Will update specific colomns with the given values where the coloumn have the wherValue
		public String[][] updateByAttributeName(String tableName , String attributeName , String attributeValue ,  String[] cols , String[] values); //Will update the given colomns with the given values for the given attribute
	
		public String[][] selectTable(String tableName); //To selct all the table
		public String[][] selectTable(String tableName , String[] cols); // To select the given colomns from the table
		public String[][] selectTable(String tableName , String[] cols , String[] values); //To select the given colomns which have the given values
		public String[][] selectTable(String tableName , String[] cols , String[] whereCol ,String [] whereValue); // To select the given colomns where the colomns have the given values
}
