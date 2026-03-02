import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;
    private final InputParser parser;
    private final StudentDataValidator validator;
    private final ConfirmationPrinter printer;

    public OnboardingService(StudentRepository repository) {
        this.repository = repository;
        this.parser = new InputParser();
        this.validator = new StudentDataValidator();
        this.printer = new ConfirmationPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);
        
        Map<String, String> data = parser.parse(raw);
        
        String name = parser.getName(data);
        String email = parser.getEmail(data);
        String phone = parser.getPhone(data);
        String program = parser.getProgram(data);

        List<String> errors = validator.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            printer.printValidationErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repository.save(rec);

        printer.printSuccess(rec, repository.count());
    }
}
