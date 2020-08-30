<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-url code="anonymous.notices.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="anonymous.notices.form.label.title" path="title"/>
	<acme:form-moment code="anonymous.notices.form.label.creation" path="creation"/>
	<acme:form-moment code="anonymous.notices.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="anonymous.notices.form.label.body" path="body"/>
	<acme:form-textbox code="anonymous.notices.form.label.links" path="links"/>
	
	<acme:form-return code="anonymous.notices.form.button.return"/>
</acme:form>