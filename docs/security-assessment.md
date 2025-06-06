# Safety Report

## Tests We Did
- **XSS**: Tried `<script>`, safe as text.
- **SQL**: Tried `1' OR '1'='1`, safe.
- **RBAC**: USER blocked from boss page, ADMIN OK.
- **JWT**: Bad codes failed.

## Tools
- ZAP: Checked for hacks.
- Postman: Tested buttons.
- Test code: TaskControllerTest.java

## Fixes
- CSRF: Added tokens to forms.
- All safe now!

## Proof
- Issues #1-#4 on GitHub
- ZAP: docs/zap-report.pdf