
<%@ page import="derivedsorts.ExampleForm" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'form.label', default: 'Form')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-form" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

			</ul>
		</div>
		<div id="list-form" class="content scaffold-list" role="main">
			<h1>Form List Example</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fullName" title="Full Name" />
					
						<g:sortableColumn property="courseName" title="Course Name" />
					
						<g:sortableColumn property="status" title="Status" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${formInstanceList}" status="i" var="formInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${formInstance.id}">${formInstance.fullName()}</g:link></td>
					
						<td>${fieldValue(bean: formInstance, field: "courseName")}</td>
					
					
						<td>${formInstance.status()}</td>
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${formInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
