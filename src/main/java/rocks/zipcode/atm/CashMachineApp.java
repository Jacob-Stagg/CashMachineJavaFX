package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {
    private CashMachine cashMachine = new CashMachine(new Bank());
    final TextField log = new TextField();
    final TextField id = new TextField();
    final TextField depositInfo = new TextField();
    final TextField withdrawInfo = new TextField();
    final TextArea areaInfo = new TextArea();

    private Parent createContent() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        log.setPromptText("Enter account name:");
        log.setPrefColumnCount(15);
        GridPane.setConstraints(log, 0, 0);
        grid.getChildren().add(log);

        id.setPromptText("Enter account ID:");
        id.setPrefColumnCount(15);
        GridPane.setConstraints(id, 0, 1);
        grid.getChildren().add(id);

        depositInfo.setPrefColumnCount(15);
        depositInfo.setPromptText("Enter deposit amount:");
        GridPane.setConstraints(depositInfo, 0, 2);
        grid.getChildren().add(depositInfo);

        withdrawInfo.setPrefColumnCount(15);
        withdrawInfo.setPromptText("Enter withdraw amount:");
        GridPane.setConstraints(withdrawInfo, 0, 3);
        grid.getChildren().add(withdrawInfo);

        areaInfo.setPrefColumnCount(15);
        GridPane.setConstraints(areaInfo, 0, 5);
        grid.getChildren().add(areaInfo);

        Button accountName = new Button("Set account ID");
        GridPane.setConstraints(accountName, 1, 1);
        accountName.setOnAction(e -> {
            int accountNum = Integer.parseInt(id.getText());
            cashMachine.login(accountNum);

            areaInfo.setText(cashMachine.toString());
        });
        grid.getChildren().add(accountName);

        Button submit = new Button("Set account ID");
        GridPane.setConstraints(submit, 1, 1);
        submit.setOnAction(e -> {
            int accountNum = Integer.parseInt(id.getText());
            cashMachine.login(accountNum);

            areaInfo.setText(cashMachine.toString());
        });
        grid.getChildren().add(submit);

        Button deposit = new Button("Deposit");
        GridPane.setConstraints(deposit, 1, 2);
        deposit.setOnAction(e -> {
            Float amount = Float.parseFloat(depositInfo.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });
        grid.getChildren().add(deposit);

        Button withdraw = new Button("Withdraw");
        GridPane.setConstraints(withdraw, 1, 3);
        withdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(withdrawInfo.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });
        grid.getChildren().add(withdraw);

        Button exit = new Button("Exit");
        GridPane.setConstraints(exit, 2, 3);
        exit.setOnAction(e -> {
            cashMachine.exit();
            areaInfo.setText(cashMachine.toString());
        });
        grid.getChildren().add(exit);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 2, 2);
        clear.setOnAction(e -> {
            id.clear();
            depositInfo.clear();
            withdrawInfo.clear();
            areaInfo.clear();
        });
        grid.getChildren().add(clear);

        return grid;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
