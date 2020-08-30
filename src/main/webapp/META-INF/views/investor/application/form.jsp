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

<acme:form>

    
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" placeholder="XXX-12-123456"/>
	
	 <jstl:if test="${command !='create'}">
	<acme:form-moment code="investor.application.form.label.creation" path="creation" readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${command !='create'}">
	<acme:form-textbox code="investor.application.form.label.status" path="status"/>
	</jstl:if>
	
	<acme:form-textarea code="investor.application.form.label.statement" path="statement"/>
	
	 
	<acme:form-money code="investor.application.form.label.money" path="money"/>
	
	
	<acme:form-submit code="investor.application.form.button.create" test="${command=='create'}"   action="/investor/application/create?InvestmentRoundId=${investmentRound.id}"/>
	

  <acme:form-return code="investor.application.form.button.return"/>
     

</acme:form>
