<#import "parts/common.ftlh" as c>

    <@c.page>

    <#--  // Filter \\-->
        <div class="form-row">
            <div class="form-group col-md-6">
                <form method="get" action="/main" class="form-inline">
                    <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag"/>
                    <button type="submit" class="btn btn-primary ml-2">Search</button>
                </form>
            </div>
        </div>


<#-- // Adding new message \\-->
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Add new message
        </a>
        <div class="collapse <#if message??>show</#if>" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" name="text" class="form-control ${(textError??)?string('is-invalid','')}"
                               value="<#if message??>${message.text}</#if>" placeholder="Enter message"/>
                        <#if textError??>
                            <div class="invalid-feedback">
                                ${textError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <input type="text" value="<#if message??>${message.tag}</#if>" name="tag"
                               class="form-control ${(tagError??)?string('is-invalid','')}" placeholder="Tag"/>
                        <#if tagError??>
                            <div class="invalid-feedback">
                                ${tagError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input type="file" name="file" id="customFile" />
                            <label class="custom-file-label" for="customFile">Choose file</label>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add message</button>
                    </div>
                </form>
            </div>
        </div>



<#-- // List of messages \\ -->
        <div class="card-columns">
        <#if messages??>
                <#list messages as message>
                    <div class="card my-3";">
        <#--                <b>${message.id}</b>-->
                        <div>
                            <#if message.filename??>
                                <img src="/img/${message.filename}" class="card-img-top">
                            </#if>
                        </div>
                        <div class="m-2">
                            <b>${message.text}</b>
                            <i>${message.tag}</i>
                        </div>
                        <div class="card-footer text-muted">
                            ${message.authorName}
                        </div>
                    </div>
                    <#else>No messages
                </#list>
            </#if>
        </div>
    </@c.page>
