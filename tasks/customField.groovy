import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.fields.CustomField

// Get the custom field manager
CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()

// Get the two number fields
CustomField numberField1 = customFieldManager.getCustomFieldObjectByName("Number Field 1")
CustomField numberField2 = customFieldManager.getCustomFieldObjectByName("Number Field 2")

// Calculate the value based on the two number fields
Double number1 = (Double) issue.getCustomFieldValue(numberField1)
Double number2 = (Double) issue.getCustomFieldValue(numberField2)
Double calculatedValue = number1 + number2

return calculatedValue