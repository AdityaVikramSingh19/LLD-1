public abstract class Exporter {
    /**
     * BASE CONTRACT:
     * Preconditions:
     *   - req must not be null
     *   - req.title and req.body may be null
     * Postconditions:
     *   - Must return a non-null ExportResult
     *   - Must NOT throw exceptions for valid inputs
     *   - If export cannot be completed, return ExportResult with success=false
     *   - If successful, return ExportResult with success=true and non-null bytes
     */
    public abstract ExportResult export(ExportRequest req);
}
