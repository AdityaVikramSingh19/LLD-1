/**
 * Base contract: send() must accept any Notification and handle it gracefully.
 * Subtypes must not throw exceptions or change semantics unexpectedly.
 * If a notification cannot be sent, handle the error internally.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract void send(Notification n);
}
