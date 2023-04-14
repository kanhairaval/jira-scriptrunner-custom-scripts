import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption

def issue = event.issue
def customFieldManager = ComponentAccessor.customFieldManager
def textField = customFieldManager.getCustomFieldObjectByName("TextField")
def selectField = customFieldManager.getCustomFieldObjectByName("Select List")

def currentUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def updateOptions = EventDispatchOption.DO_NOT_DISPATCH

if(!event.getUser().getDisplayName().equalsIgnoreCase("Your Listener Username")) {
def changeHolder = event.getChangeLog()
def changeItems = changeHolder.getChangeItems()