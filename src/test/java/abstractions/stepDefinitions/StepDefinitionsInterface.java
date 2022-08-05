package abstractions.stepDefinitions;

import abstractions.helpers.NavigateHelper;
import abstractions.helpers.ProductHelper;
import abstractions.pageObjects.Footer;
import abstractions.pageObjects.Mac.BuyMac.BuyMac;
import abstractions.utils.AssertionMethods;
import abstractions.pageObjects.Navbar;
import abstractions.pageObjects.SearchResults;

public interface StepDefinitionsInterface {
    Navbar navbar = new Navbar();
    Footer footer = new Footer();
    SearchResults searchResults = new SearchResults();
    NavigateHelper navigateHelper = new NavigateHelper();

    ProductHelper productHelper = new ProductHelper();

    BuyMac buyMac = new BuyMac();
    AssertionMethods assertionMethods = new AssertionMethods();
}
