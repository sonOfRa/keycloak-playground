<#import "template.ftl" as layout>
<@layout.registrationLayout; section>

    <#if section = "header">
        Dummy Action
    <#elseif section = "form">
        <div>
            <form action="${url.loginAction}" method="post">
                    <input name="doSuccess" id="doSuccess" type="submit" value="Succeed Action" >
                    <input name="doFailure" id="doFailure" type="submit" value="Fail Action" >
            </form>
        </div>
    </#if>

</@layout.registrationLayout>
