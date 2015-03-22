package org.bookprof.importer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.bookprof.model.book.Author;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.Publisher;

/**
 * Created by kr on 21/03/15.
 */
public class ExcelImporter {

  public Map initCategories() {
    Map<Integer, String> bookTypeCategories = new HashMap();

    bookTypeCategories.put(1, "RELIGION");
    /*bookTypeCategories.put(2, "ILAKKANAM");
    bookTypeCategories.put(3, "Resech");
    bookTypeCategories.put(4, "MUSIC");
    bookTypeCategories.put(5, "DANCE");
    bookTypeCategories.put(6, "DRAMA");
    bookTypeCategories.put(7, "NOVEL");
    bookTypeCategories.put(8, "ILAKKIYAM");
    bookTypeCategories.put(9, "BABY`s NOVEL");
    bookTypeCategories.put(10, "HISTORY1");
    bookTypeCategories.put(11, "SPORT");
    bookTypeCategories.put(12, "OTHER BOKS");
    bookTypeCategories.put(13, "wroter-books");
    */
    return bookTypeCategories;

  }

  public List<BookType> importFile(String filePath) throws IOException {


    List bookTypes = new ArrayList<BookType>();

    Set<Map.Entry<Integer, String>> set = initCategories().entrySet();
    for (Map.Entry<Integer, String> entry : set) {

      Integer sheetNr = entry.getKey();
      String categoryName = entry.getValue();


      String fileName = String.format(filePath, sheetNr);


      bookTypes.addAll(importSheet(sheetNr, categoryName, fileName));
    }

    return bookTypes;
  }

  private List<BookType> importSheet(Integer sheetNr, String categoryName, String fileName) throws FileNotFoundException {
    assert fileName != null;
    assert sheetNr > 0;
    assert categoryName != null;

    List<BookType> bookTypes = new ArrayList<BookType>();

    List<String[]> entries = readFromCvs(fileName);

    bookTypes.addAll(importFromEntries(entries));

    return bookTypes;
  }

  private List<BookType> importFromEntries(List<String[]> entries) {
    List<BookType> bookTypes = new ArrayList<BookType>();
    for (String[] entry : entries) {
      BookType bookType = parseLine(entry[0]);

      bookTypes.add(bookType);
    }
    return bookTypes;
  }

  private BookType parseLine(String s) {
    BookType bookType = new BookType();
    String line = s;

    String[] col = line.split("\"");

    return BookTypeColumn.parse(col);
  }

  private String getColValue(String[] col, int i) {
    return col[i];
  }

  private List<String[]> readFromCvs(String fileName) throws FileNotFoundException {
    int skipLines = 3;
    CSVReader reader = new CSVReader(new FileReader(fileName), ',', CSVParser.DEFAULT_QUOTE_CHARACTER, skipLines);

    try {
      return reader.readAll();
    }
    catch (IOException e) {

      throw new RuntimeException("Could not read all from file: " + fileName);
    }
  }
}

enum BookTypeColumn {
  INTERNAL_ID,
  BOOK_NAME,
  AUTHOR,
  PUBLISHER,
  YEAR,
  PAGE,
  NR,
  SHELF;

  BookTypeColumn() {
  }


  public static BookType parse(String[] col) {
    BookType bookType = new BookType();
    for (BookTypeColumn field : values()) {
      if (col.length > field.ordinal()) {

        String colValue = col[field.ordinal()];
        if (colValue != null) {
          setValue(bookType, colValue, field);
        }
      }

    }
    return bookType;

  }

  private static void setValue(BookType bookType, String colValue, BookTypeColumn field) {
    switch (field) {
      case INTERNAL_ID:
        bookType.setInternalId(colValue);
        break;
      case BOOK_NAME:
        bookType.setName(colValue);
        break;
      case AUTHOR:
        bookType.setAuthor(new Author(colValue));
        break;
      case PUBLISHER:
        bookType.setPublisher(new Publisher(colValue));
        break;
      case YEAR:
        int year = getIntValue(colValue);
        bookType.setYear(year);
        break;
      case PAGE:
        int page = getIntValue(colValue);
        bookType.setPage(page);
        break;
      case NR:
        bookType.setNr(getIntValue(colValue));
        break;
      case SHELF:
        bookType.setShelf(colValue);
        break;
    }
  }

  private static int getIntValue(String colValue) {
    try {
      return Integer.parseInt(colValue);
    }
    catch (NumberFormatException ne) {
      return 0;
    }

  }
}