// For the "Create" screen only, create a Behaviour which prefixes an issue's summary
// field to display "URGENT: " when the priority field value is "High" or "Highest". If the
// priority field value is "Medium" or lower, remove the "URGENT: " summary prefix.
// This Behaviour should not work on the Edit Screen.

import com.onresolve.jira.groovy.user.FieldBehaviours  // Importing FieldBehaviours from the package com.onresolve.jira.groovy.user
import com.atlassian.jira.issue.priority.Priority      // Importing Priority from the package com.atlassian.jira.issue.priority
import groovy.transform.BaseScript                     // Importing BaseScript from the package groovy.transform

@BaseScript FieldBehaviours fieldBehaviours             // Setting the current script as a BaseScript for FieldBehaviours

def priorityField = getFieldById('priority')           // Getting the Priority field by its ID and storing it in the variable 'priorityField'
def summaryField = getFieldById('summary')             // Getting the Summary field by its ID and storing it in the variable 'summaryField'

if (priorityField.value?.name in ['High', 'Highest']) { // Checking if the value of the Priority field is either 'High' or 'Highest'
    summaryField.setFormValue('Urgent: ' + summaryField.value)  // Setting the form value of the Summary field to 'Urgent: ' + the current value of the Summary field
} else {
    summaryField.setFormValue(summaryField.value)      // Setting the form value of the Summary field to the current value of the Summary field
}

// The above code is a Behaviour which prefixes an issue's summary field to display "URGENT: " when the priority field value is "High" or "Highest". If the priority field value is "Medium" or lower, remove the "URGENT: " summary prefix. This Behaviour should not work on the Edit Screen.