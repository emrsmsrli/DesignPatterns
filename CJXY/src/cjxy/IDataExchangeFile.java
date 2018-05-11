package cjxy;

public interface IDataExchangeFile {
    public IDataExchangeFile convertToCSV();
    public IDataExchangeFile convertToJSON();
    public IDataExchangeFile convertToXML();
    public IDataExchangeFile convertToYAML();
}
