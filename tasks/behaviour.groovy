// For the "Create" screen only, create a Behaviour which prefixes an issue's summary
// field to display "URGENT: " when the priority field value is "High" or "Highest". If the
// priority field value is "Medium" or lower, remove the "URGENT: " summary prefix.
// This Behaviour should not work on the Edit Screen.

import com.atlassian.jira.component.ComponentAccessor

//Gets the Priority and Summary Fields
def priorityField = getFieldById(getFieldChanged())
def summaryField = getFieldById("summary")

//Gets the value of the Priority Field
def priorityValue = priorityField.getValue()

//Checks if the Priority Field is the field that triggered the script
if (getFieldChanged() == "priority") {
    //Checks if the Priority Field is being set to High or Highest
    if (priorityValue == "High" || priorityValue == "Highest") {
        //Prepends "URGENT: " to the Summary Field
        def summaryValue = "URGENT: " + summaryField.getValue()
        summaryField.setFormValue(summaryValue)
    }
    //Checks if the Priority Field is being set to Medium or Lower
    else if (priorityValue == "Medium" || priorityValue == "Low" || priorityValue == "Lowest") {
        //Removes "URGENT: " from the Summary Field
        def summaryValue = summaryField.getValue() as String
        summaryValue = summaryValue.replace("URGENT: ", "")
        summaryField.setFormValue(summaryValue)

    }
}

// The above code is a Behaviour which prefixes an issue's summary field to display "URGENT: " when the priority field value is "High" or "Highest". If the priority field value is "Medium" or lower, remove the "URGENT: " summary prefix. This Behaviour should not work on the Edit Screen.