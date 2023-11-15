package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.model.Customer;
import christmas.model.Event;
import christmas.util.Constant;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Event event;
    Customer customer;

    public void initialize() {
        customer = new Customer(inputView.inputVisitDate(), inputView.inputOrderMenu());
        if (customer.checkEventRequirement()) {
            event = new Event(customer.getVisitDate(), customer.getTotalPrice(), getCurrentMenuCount());
        }
        if (!customer.checkEventRequirement()) {
            event = new Event();
        }
    }

    public void start() {
        initialize();
        outputView.printGuide(customer.getVisitDate());
        outputView.printOrder(customer.getOrder());
        outputView.printBeforeDiscount(customer.getTotalPrice());
        outputView.printGiveawayMenu(event.isChampagneEvent());

        outputView.printBenefitList(event.getEventList(getCurrentMenuCount()));
        outputView.printTotalBenefit(event.getTotalBenefit());
        outputView.printForPay(customer.getTotalPrice(), event.getTotalDiscount());
        outputView.printEventBatch(event.getBatch());


    }

    public int getCurrentMenuCount() {
        if (Constant.WEEKEND.contains(customer.getVisitDate() % Constant.WEEK)) {
            return customer.getMainMenuCount();
        }
        return customer.getDesertCount();
    }

}
