import com.atlassian.jira.component.ComponentAccessor  // Importing the Jira ComponentAccessor class
import com.atlassian.jira.issue.CustomFieldManager  // Importing the Jira CustomFieldManager class
import com.atlassian.jira.issue.fields.CustomField  // Importing the Jira CustomField class

// Get the custom field manager
CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()  // Create a new CustomFieldManager object using ComponentAccessor

// Get the two number fields
CustomField numberField1 = customFieldManager.getCustomFieldObjectByName("Number Field 1")  // Get the CustomField object for the first Number field
CustomField numberField2 = customFieldManager.getCustomFieldObjectByName("Number Field 2")  // Get the CustomField object for the second Number field

// Calculate the value based on the two number fields
Double number1 = (Double) issue.getCustomFieldValue(numberField1)  // Get the value of the first Number field from the current issue and convert it to a Double
Double number2 = (Double) issue.getCustomFieldValue(numberField2)  // Get the value of the second Number field from the current issue and convert it to a Double
Double calculatedValue = number1 + number2  // Add the two numbers together to calculate the total

return calculatedValue  // Return the calculated value to be displayed in the custom field
