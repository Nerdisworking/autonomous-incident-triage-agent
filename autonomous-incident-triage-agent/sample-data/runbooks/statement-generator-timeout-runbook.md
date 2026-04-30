# Statement Generator Timeout Runbook

## Symptoms

- Increased 5xx rate
- ReadTimeoutException
- Downstream renderer latency above threshold
- Retry budget exhaustion

## Checks

1. Validate latest deployment version.
2. Compare error rate before and after deployment.
3. Check downstream renderer latency.
4. Inspect retry policy changes.
5. Validate rollback readiness.

## Recommended Action

If timeout increase correlates strongly with latest deployment, roll back to previous stable version and monitor for 15 minutes.
