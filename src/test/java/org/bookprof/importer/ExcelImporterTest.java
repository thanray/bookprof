package org.bookprof.importer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.bookprof.model.book.BookType;
import org.junit.Test;

public class ExcelImporterTest {

  private static final String libraryFile = "/Users/kr/dev/bookProf/library/csv/BIBLIOTEK-1.csv";

  ExcelImporter excelImporter = new ExcelImporter();

  @Test
  public void testImportFile() throws Exception {

    List<BookType> bookTypes = excelImporter.importFile(libraryFile);

    assertNotNull(bookTypes);
    assertFalse(bookTypes.isEmpty());


  }
}