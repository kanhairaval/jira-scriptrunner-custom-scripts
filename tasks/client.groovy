import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.customfields.option.Option

def issueManager = ComponentAccessor.issueManager
def customFieldManager = ComponentAccessor.customFieldManager
def optionsManager = ComponentAccessor.optionsManager
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser

def textField = customFieldManager.getCustomFieldObject("customfield_10117")
def selectField = customFieldManager.getCustomFieldObject("customfield_10116")

def issueId = event.issue.id
def issue = issueManager.getIssueObject(issueId)

issue.setCustomFieldValue(textField, "Updated")

def optionSet = optionsManager.getOptions(selectField.getRelevantConfig(issue))
if (optionSet) {
  def selectedOption = optionSet.getOptionForValue("New Value", null)
  issue.setCustomFieldValue(selectField, selectedOption)
}

issueManager.updateIssue(user, issue, EventDispatchOption.DO_NOT_DISPATCH, false)
