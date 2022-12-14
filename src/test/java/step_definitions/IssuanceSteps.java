package step_definitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;
import utilities.PoJos.Details;
import utilities.PoJos.DetailsPOJO;
import utilities.ReqNResSpec;



import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static utilities.ReqNResSpec.getReqSpec;


public class IssuanceSteps {
    Details details = new Details();
    DetailsPOJO detailsPOJO = new DetailsPOJO();
    Faker fake = new Faker();
    String prefix ="BBG";

    @Given("the following details")
    public void the_following_details(Map<String, String> dataTable) {

        //System.out.println("dataTable"+dataTable);


        //String IssuanceDataKey = dataTable.get("DatasourceId") + ":" + dataTable.get("IssuerTicker");
        detailsPOJO.setMessageType("EVENT_NEW_ISSUANCE_DATA");
        detailsPOJO.setServiceName("ISSUANCE_EVENT_HANDLER");
        details.setDatasourceId(dataTable.get("DatasourceId"));
        details.setIssuanceDataKey(prefix +":"+ fake.currency().code());
        details.setIssuerTicker(fake.name().lastName().toUpperCase());
        details.setIssuerName(fake.country().currencyCode());
        details.setMaturityDate(Long.valueOf(dataTable.get("MaturityDate")));
        details.setCurrencyCode(dataTable.get("CurrencyCode"));
        details.setIssuerCountry(dataTable.get("IssuerCountry"));
        details.setTrancheCurrency(dataTable.get("TrancheCurrency"));
        details.setIssuerRating(dataTable.get("IssuerRating"));
        details.setIpts(dataTable.get("Ipts"));
        details.setDealStatus(dataTable.get("DealStatus"));
        details.setBookStatus(dataTable.get("BookStatus"));
        details.setBondSeniority(dataTable.get("BondSeniority"));
        details.setTotalIssuedAmount(dataTable.get("TotalIssuedAmount"));
        details.setTrancheSettlementDate(dataTable.get("TrancheSettlementDate"));
        details.setFirstCallDate(dataTable.get("FirstCallDate"));
        details.setIsPerpetual(Boolean.valueOf(dataTable.get("IsPerpetual")));
        detailsPOJO.setDETAILS(details);
        //System.out.println("issuername"+details.getIssuerName());
        //System.out.println("details"+details);

    }
    @When("I creating an issuance")
    public void i_creating_an_issuance() {
        baseURI = "http://" + ConfigReader.readProperty("hsbcIssuance") + ":9064";
        RequestSpecification super_admin = getReqSpec("SUPER_ADMIN");
        given()
                .spec(super_admin).
                body(detailsPOJO).
                when()
                .post("/event_new_issuance_data").
                then()
                .spec(ReqNResSpec.getRespSpec())
        ;
    }

    @Given("that following details are available")
    public void thatFollowingDetailsAreAvailable(Map<String, String> dataTable) {
        System.out.println("datatable"+dataTable);
        detailsPOJO.setMessageType("EVENT_NEW_ISSUANCE_DATA");
        detailsPOJO.setServiceName("ISSUANCE_EVENT_HANDLER");
        details.setDatasourceId(dataTable.get("DatasourceId"));
        details.setIssuanceDataKey(prefix +":"+ fake.currency().code());
        details.setIssuerTicker(fake.name().lastName().toUpperCase());
        details.setIssuerName(fake.country().currencyCode());
        details.setMaturityDate(Long.valueOf(dataTable.get("MaturityDate")));
        details.setCurrencyCode(dataTable.get("CurrencyCode"));
        details.setIssuerCountry(dataTable.get("IssuerCountry"));
        details.setTrancheCurrency(dataTable.get("TrancheCurrency"));
        details.setIssuerRating(dataTable.get("IssuerRating"));
        details.setIpts(dataTable.get("Ipts"));
        details.setDealStatus(dataTable.get("DealStatus"));
        details.setBookStatus(dataTable.get("BookStatus"));
        details.setBondSeniority(dataTable.get("BondSeniority"));
        details.setTotalIssuedAmount(dataTable.get("TotalIssuedAmount"));
        details.setTrancheSettlementDate(dataTable.get("TrancheSettlementDate"));
        details.setFirstCallDate(dataTable.get("FirstCallDate"));
        details.setIsPerpetual(Boolean.valueOf(dataTable.get("IsPerpetual")));
        detailsPOJO.setDETAILS(details);

    }

    @Given("the following details for perpetual issuance")
    public void theFollowingDetailsForPerpetualIssuance(Map<String, String> dataTable) {
        {
            detailsPOJO.setMessageType("EVENT_NEW_ISSUANCE_DATA");
            detailsPOJO.setServiceName("ISSUANCE_EVENT_HANDLER");
            details.setDatasourceId(dataTable.get("DatasourceId"));
            details.setIssuanceDataKey(prefix +":"+ fake.currency().code());
            details.setIssuerTicker(fake.name().lastName().toUpperCase());
            details.setIssuerName(fake.country().currencyCode());
            details.setCurrencyCode(dataTable.get("CurrencyCode"));
            details.setIssuerCountry(dataTable.get("IssuerCountry"));
            details.setTrancheCurrency(dataTable.get("TrancheCurrency"));
            details.setIssuerRating(dataTable.get("IssuerRating"));
            details.setIpts(dataTable.get("Ipts"));
            details.setDealStatus(dataTable.get("DealStatus"));
            details.setBookStatus(dataTable.get("BookStatus"));
            details.setBondSeniority(dataTable.get("BondSeniority"));
            //details.setTotalIssuedAmount(dataTable.get("TotalIssuedAmount"));
            details.setTrancheSettlementDate(dataTable.get("TrancheSettlementDate"));
            details.setFirstCallDate(dataTable.get("FirstCallDate"));
            details.setIsPerpetual(Boolean.valueOf(dataTable.get("IsPerpetual")));
            detailsPOJO.setDETAILS(details);

        }

    }

    @Given("the following dealsize details")
    public void theFollowingDealsizeDetails(Map<String, String> dataTable) {
        detailsPOJO.setMessageType("EVENT_NEW_ISSUANCE_DATA");
        detailsPOJO.setServiceName("ISSUANCE_EVENT_HANDLER");
        details.setDatasourceId(dataTable.get("DatasourceId"));
        details.setIssuanceDataKey(prefix +":"+ fake.currency().code());
        details.setIssuerTicker(fake.name().lastName().toUpperCase());
        details.setIssuerName(fake.country().currencyCode());
        details.setCurrencyCode(dataTable.get("CurrencyCode"));
        details.setIssuerCountry(dataTable.get("IssuerCountry"));
        details.setTrancheCurrency(dataTable.get("TrancheCurrency"));
        details.setIssuerRating(dataTable.get("IssuerRating"));
        details.setIpts(dataTable.get("Ipts"));
        details.setDealStatus(dataTable.get("DealStatus"));
        details.setBookStatus(dataTable.get("BookStatus"));
        details.setBondSeniority(dataTable.get("BondSeniority"));
        //details.setTotalIssuedAmount(dataTable.get("TotalIssuedAmount"));
        details.setTrancheSettlementDate(dataTable.get("TrancheSettlementDate"));
        details.setFirstCallDate(dataTable.get("FirstCallDate"));
        details.setIsPerpetual(Boolean.valueOf(dataTable.get("IsPerpetual")));
        detailsPOJO.setDETAILS(details);
    }

    /*@Given("User enters {string}")
    public void user_enters(String string) {
        System.out.println("Names = " + string);
    }
    @When("User enters lastname")
    public void user_enters_lastname(List<String> strings) {
        System.out.println("Lastname = " + strings);
    }
    @Then("user verifies {string}")
    public void user_verifies(String lastname) {
        System.out.println("random = " + lastname);
    }*/
    }
