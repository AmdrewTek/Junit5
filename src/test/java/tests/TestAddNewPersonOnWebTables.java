package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WebTablesPage;

import java.util.stream.Stream;

@DisplayName("Тест внесения пользователей в таблицу")
public class TestAddNewPersonOnWebTables extends TestBase {
  WebTablesPage webTablesPage = new WebTablesPage();

  static Stream<Arguments> testAddNewUserOnWebTabelWithMethodSource() {
    return Stream.of(
      Arguments.of("And", "Tek", "amd@tek.com", "25", "15000", "Legal"),
      Arguments.of("Anb", "Pek", "amb@tek.com", "08", "30000", "Insurance")
    );
  }

  @ParameterizedTest(name = "Тест заполнения формы c CSV для {0} {1}")
  @CsvSource(value = {
    "And, Tek, amd@tek.com, 25, 15000, Legal",
    "Anb, Pek, amb@tek.com, 08, 30000, Insurance"
  })
  void testAddNewUserOnWebTablesWithCSV(
    String userFirstName,
    String userLastName,
    String userEmail,
    String userAge,
    String userSalary,
    String userDepartment
  ) {
    webTablesPage
      .openPage()
      .closeBanner()
      .addNewPerson()
      .inputFirstName(userFirstName)
      .inputLastName(userLastName)
      .inputEmail(userEmail)
      .inputAge(userAge)
      .inputSalary(userSalary)
      .inputDepartment(userDepartment)
      .submitButton()
      .checkResult(
        userFirstName,
        userLastName,
        userEmail,
        userAge,
        userSalary,
        userDepartment
      );
  }

  @ParameterizedTest(name = "Тест заполнения формы c CSV-file для {0} {1}")
  @CsvFileSource(resources = "/usersData.csv", numLinesToSkip = 1)
  void testAddNewUserOnWebTableWithCSVFile(
    String userFirstName,
    String userLastName,
    String userEmail,
    String userAge,
    String userSalary,
    String userDepartment
  ) {
    webTablesPage
      .openPage()
      .closeBanner()
      .addNewPerson()
      .inputFirstName(userFirstName)
      .inputLastName(userLastName)
      .inputEmail(userEmail)
      .inputAge(userAge)
      .inputSalary(userSalary)
      .inputDepartment(userDepartment)
      .submitButton()
      .checkResult(
        userFirstName,
        userLastName,
        userEmail,
        userAge,
        userSalary,
        userDepartment
      );
  }

  @ParameterizedTest(name = "Тест заполнения формы c MethodSource {0} {1}")
  @MethodSource("testAddNewUserOnWebTabelWithMethodSource")
  void testAddNewUserOnWebTabelWithMethodSource(
    String userFirstName,
    String userLastName,
    String userEmail,
    String userAge,
    String userSalary,
    String userDepartment
  ) {
    webTablesPage
      .openPage()
      .closeBanner()
      .addNewPerson()
      .inputFirstName(userFirstName)
      .inputLastName(userLastName)
      .inputEmail(userEmail)
      .inputAge(userAge)
      .inputSalary(userSalary)
      .inputDepartment(userDepartment)
      .submitButton()
      .checkResult(
        userFirstName,
        userLastName,
        userEmail,
        userAge,
        userSalary,
        userDepartment
      );
  }

}
