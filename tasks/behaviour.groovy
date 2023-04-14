// For the "Create" screen only, create a Behaviour which prefixes an issue's summary
// field to display "URGENT: " when the priority field value is "High" or "Highest". If the
// priority field value is "Medium" or lower, remove the "URGENT: " summary prefix.
// This Behaviour should not work on the Edit Screen.

import com.atlassian.jira.issue.Issue

// Checking if the issue is being created
def created = getActionName() == "Create Issue"

if (created) {
    // Getting the priority field
    def priorityField = getFieldByName("priority")

    // Getting the summary field
    def summaryField = getFieldByName("summary")

    // Getting the current value of the priority field
    def priorityValue = priorityField.getValue() as String

    // Checking if the priority is High or Highest
    if (priorityValue == "High" || priorityValue == "Highest") {
        // Prepend "URGENT: " to the summary field value
        def summaryValue = "URGENT: " + summaryField.getValue()
        summaryField.setFormValue(summaryValue)
    } else {
        // Removing "URGENT: " prefix from the summary field value
        def summaryValue = summaryField.getValue()
        summaryValue = summaryValue.replaceFirst("URGENT: ", "")
        summaryField.setFormValue(summaryValue)
    }
}

// The above code is a Behaviour which prefixes an issue's summary field to display "URGENT: " when the priority field value is "High" or "Highest". If the priority field value is "Medium" or lower, remove the "URGENT: " summary prefix. This Behaviour should not work on the Edit Screen.