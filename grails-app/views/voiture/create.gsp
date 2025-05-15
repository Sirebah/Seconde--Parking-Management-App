<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'voiture.label', default: 'Voiture')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
    <asset:stylesheet href="voiture.css" />
</head>
<body>
<div id="content" role="main">
    <div class="container">
        <section class="row">
            <a href="#create-voiture" class="skip" tabindex="-1">
                <g:message code="default.link.skip.label" default="Skip to content…" />
            </a>
            <div class="nav" role="navigation">
                <ul>
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></li>
                    <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </ul>
            </div>
        </section>
        <section class="row">
            <div id="create-voiture" class="col-12 content scaffold-create" role="main">
                <h1><g:message code="default.create.label" args="[entityName]" /></h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:hasErrors bean="voiture">
                    <ul class="errors" role="alert">
                        <g:eachError bean="voiture" var="error">
                            <g:if test="${error instanceof org.springframework.validation.FieldError}">
                                <li data-field-id="${error.field}"><g:message error="${error}"/></li>
                            </g:if>
                            <g:else>
                                <li><g:message error="${error}"/></li>
                            </g:else>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <g:form resource="${voiture}" method="POST">
                    <fieldset class="form">
                        <div class="fieldcontain ${hasErrors(bean: voiture, field: 'immatriculation', 'error')}">
                            <f:field bean="voiture" property="immatriculation" />
                            <g:fieldError bean="voiture" field="immatriculation" />
                        </div>

                        <div class="fieldcontain ${hasErrors(bean: voiture, field: 'marque', 'error')}">
                            <f:field bean="voiture" property="marque" />
                            <g:fieldError bean="voiture" field="marque" />
                        </div>

                        <div class="fieldcontain ${hasErrors(bean: voiture, field: 'proprietaire', 'error')}">
                            <f:field bean="voiture" property="proprietaire" />
                            <g:fieldError bean="voiture" field="proprietaire" />
                        </div>

                        <div class="fieldcontain ${hasErrors(bean: voiture, field: 'year', 'error')}">
                            <label for="year"><g:message code="voiture.year.label" default="Année" /><span class="required">*</span></label>
                            <input type="number" name="year" id="year" value="${voiture?.year}" min="1986" max="2030" step="1" required="required" />
                            <g:fieldError bean="voiture" field="year" />
                        </div>
                    </fieldset>

                    <fieldset class="buttons">
                        <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                    </fieldset>
                </g:form>
                <br/><hr/><br/>
                <g:form controller="voiture" action="importFromXml" enctype="multipart/form-data" method="POST">
                    <label for="xmlFile"><g:message code="default.import.label" default="Import a XML file :" /></label>
                    <input type="file" name="xmlFile" id="xmlFile" accept=".xml" required />
                    <g:submitButton name="import" value="${message(code: 'default.button.import.label', default: 'Import XML')}" />
                </g:form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
