// Create a Listener which updates the issue description with the issue's last
// comment. Tip: check out the Adaptavist Library for script examples.

import com.atlassian.jira.event.type.EventDispatchOption  // Importing the required classes for the script
import com.atlassian.jira.component.ComponentAccessor

def issue = event.issue  // Getting the issue object from the event

def comment = ComponentAccessor.getCommentManager().getLastComment(issue).body  // Retrieving the last comment on the issue
if (comment) {  // If there is a comment, continue with the script
    def issueManager = ComponentAccessor.getIssueManager()  // Retrieving the issue manager
    def mutableIssue = issueManager.getIssueObject(issue.id)  // Retrieving a mutable issue object
    mutableIssue.setDescription(comment)  // Setting the description of the mutable issue object to the comment
    issueManager.updateIssue(null, mutableIssue, EventDispatchOption.ISSUE_UPDATED, false)  // Updating the issue with the new description
}