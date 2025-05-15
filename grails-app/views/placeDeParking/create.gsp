<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'placeDeParking.label', default: 'PlaceDeParking')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<div id="content" role="main">
    <div class="container">
        <section class="row">
            <a href="#create-placeDeParking" class="skip" tabindex="-1">
                <g:message code="default.link.skip.label" default="Skip to content&hellip;" />
            </a>
            <div class="nav" role="navigation">
                <ul>
                    <li>
                        <a class="home" href="${createLink(uri: '/')}">
                            <g:message code="default.home.label" default="Home" />
                        </a>
                    </li>
                    <li>
                        <g:link class="list" action="index">
                            <g:message code="default.list.label" args="[entityName]" default="List ${entityName}" />
                        </g:link>
                    </li>
                </ul>
            </div>
        </section>

        <section class="row">
            <div id="create-placeDeParking" class="col-12 content scaffold-create" role="main">
                <h1>
                    <g:message code="default.create.label" args="[entityName]" default="Create ${entityName}" />
                </h1>

                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>

                <g:hasErrors bean="${this.placeDeParking}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.placeDeParking}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                                <g:message error="${error}" />
                            </li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>

                <g:form resource="${this.placeDeParking}" method="POST">
                    <fieldset class="form">
                        <div class="fieldcontain ${hasErrors(bean: placeDeParking, field: 'numero', 'error')}">
                            <label for="numero">
                                <g:message code="placeDeParking.numero.label" default="Number" />
                            </label>
                            <f:field bean="placeDeParking" property="numero" />
                            <g:fieldError bean="placeDeParking" field="numero" />
                        </div>

                        <div class="fieldcontain ${hasErrors(bean: placeDeParking, field: 'estOccupee', 'error')}">
                            <label for="estOccupee">
                                <g:message code="placeDeParking.estOccupee.label" default="Occupied" />
                            </label>
                            <f:field bean="placeDeParking" property="estOccupee" />
                            <g:fieldError bean="placeDeParking" field="estOccupee" />
                        </div>
                    </fieldset>


                    <fieldset class="buttons">
                        <g:submitButton name="create" class="save"
                                        value="${message(code: 'default.button.create.label', default: 'Create')}" />
                    </fieldset>
                </g:form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
