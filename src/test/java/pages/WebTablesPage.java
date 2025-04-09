package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {
  private final SelenideElement rtTable = $(".rt-table"),
    addButton = $("#addNewRecordButton"),
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userAgeInput = $("#age"),
    userSalaryInput = $("#salary"),
    userDepartmentInput = $("#department"),
    userSubmitButton = $("#submit");

  public WebTablesPage openPage() {
    open("/webtables");
    return this;
  }

  public WebTablesPage closeBanner() {
    executeJavaScript("$('#fixedban').remove()");//Закрывают баннеры
    executeJavaScript("$('footer').remove()");
    return this;
  }

  public WebTablesPage addNewPerson() {
    addButton.click();
    return this;
  }

  public WebTablesPage inputFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }

  public WebTablesPage inputLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public WebTablesPage inputEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public WebTablesPage inputAge(String value) {
    userAgeInput.setValue(value);
    return this;
  }

  public WebTablesPage inputSalary(String value) {
    userSalaryInput.setValue(value);
    return this;
  }

  public WebTablesPage inputDepartment(String value) {
    userDepartmentInput.setValue(value);
    return this;
  }

  public WebTablesPage submitButton() {
    userSubmitButton.click();
    return this;
  }

  public WebTablesPage checkResult(
    String userFirstName,
    String userLastName,
    String userEmail,
    String userAge,
    String userSalary,
    String userDepartment

  ) {
    rtTable.shouldHave(
      text(userFirstName),
      text(userLastName),
      text(userEmail),
      text(userAge),
      text(userSalary),
      text(userDepartment)
    );
    return this;
  }


}
