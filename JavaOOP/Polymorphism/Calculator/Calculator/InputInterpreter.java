package Polymorphism.Calculator;

public class InputInterpreter {
    private CalculationEngine engine;
    private Memory memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new Memory();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        Operation operation1 = null;

        if (operation.equals("*")) {
            operation1 = new MultiplicationOperation();
            this.memory.setLastOperation(operation);
        } else if (operation.equals("/")) {
            operation1 = new DivideOperation();
            this.memory.setLastOperation(operation);
        } else if (operation.equals("ms")) {
            this.memory.pushNumber(this.engine.getCurrentResult());
        } else if (operation.equals("mr")) {
            this.engine.pushNumber(this.memory.getNumber());
        }

        return operation1;
    }
}