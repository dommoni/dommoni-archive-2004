<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<h:form>
		Username: <h:inputText value="#{loginBacking.username}" />
		Password: <h:inputText value="#{loginBacking.password}" />
		
		<h:commandButton action="loginBacking.doLogin()" value="Login" />
	</h:form>
</f:view>