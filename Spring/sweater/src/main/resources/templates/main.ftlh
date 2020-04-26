<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
    <@c.page>

<#-- // Logout \\-->
        <div> <@l.logout></@l.logout> </div>

<#-- // Adding new message \\-->
        <div>
            <h3>Add your message</h3>
            <form method="post" action="add">
                <input type="text" name="text" placeholder="Enter message"/>
                <input type="text" name="tag" placeholder="Tag"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Add message</button>
            </form>
            <br />
        </div>

<#--  // Filter \\-->
       <div>
           <form method="get" action="/main">
               <input type="text" name="filter" value="${filter}"/>
<#--               csrf token only for post requests-->
<#--               <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
               <button type="submit">Find message</button>
           </form>
       </div>

<#-- // List of messages \\ -->
        <div>
            <h3>All messages: </h3>
        <#list messages as message>
            <div>
                <b>${message.id}</b>
                <b>${message.text}</b>
                <i>${message.tag}</i>
                <strong>${message.authorName}</strong>
            </div>
            <#else>No messages
        </#list>
        </div>
    </@c.page>
