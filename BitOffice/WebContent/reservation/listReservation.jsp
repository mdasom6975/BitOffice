<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app-title">
        <div>
          <h1>회의실별 예약 현황</h1>
        </div>
      </div>
	<c:set var="i" value="0" />
	<c:forEach var="reservation" items="${list}">
	<c:set var="i" value="${ i+1 }" />
	</c:forEach>
 
<div class="row">
     <div class="col-md-6">
          <div class="tile">

            <table class="table table-hover">
              <thead>
                <tr>
					<th colspan="6">XX일</th>
					<th colspan="5"></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">9:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">9:00-10:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">10:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">10:00-11:00</span></td>
                </c:if>	
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">11:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">11:00-12:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">12:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">12:00-13:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">13:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">13:00-14:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">14:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">14:00-15:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">15:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">15:00-16:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">16:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">16:00-17:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue" >17:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">17:00-18:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">18:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">18:00-19:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">19:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">19:00-20:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">20:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">20:00-21:00</span></td>
                </c:if>
                </tr>
                

                
              </tbody>
            </table>
          </div>
        </div>
     
     <div class="col-md-6">
          <div class="tile">

            <table class="table table-hover">
              <thead>
                <tr>
					<th colspan="6">XX일</th>
					<th colspan="5"></th>
                </tr>
              </thead>
              <tbody>
                 <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">9:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">9:00-10:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">10:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">10:00-11:00</span></td>
                </c:if>	
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">11:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">11:00-12:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">12:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">12:00-13:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">13:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">13:00-14:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">14:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">14:00-15:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">15:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">15:00-16:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">16:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">16:00-17:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue" >17:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">17:00-18:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">18:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">18:00-19:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">19:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">19:00-20:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">20:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">20:00-21:00</span></td>
                </c:if>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
        
     <div class="col-md-6">
          <div class="tile">

            <table class="table table-hover">
              <thead>
                <tr>
					<th colspan="6">XX일</th>
					<th colspan="5"></th>
                </tr>
              </thead>
              <tbody>
                 <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">9:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">9:00-10:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">10:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">10:00-11:00</span></td>
                </c:if>	
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">11:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">11:00-12:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">12:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">12:00-13:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">13:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">13:00-14:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">14:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">14:00-15:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">15:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">15:00-16:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">16:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">16:00-17:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue" >17:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">17:00-18:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">18:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">18:00-19:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">19:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">19:00-20:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">20:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">20:00-21:00</span></td>
                </c:if>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
        
     <div class="col-md-6">
          <div class="tile">

            <table class="table table-hover">
              <thead>
                <tr>
					<th colspan="6">XX일</th>
					<th colspan="5"></th>
                </tr>
              </thead>
              <tbody>
                 <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">9:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">9:00-10:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">10:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">10:00-11:00</span></td>
                </c:if>	
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">11:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">11:00-12:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">12:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">12:00-13:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">13:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">13:00-14:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">14:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">14:00-15:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">15:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">15:00-16:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">16:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">16:00-17:00</span></td>
                </c:if>
                </tr>
                
                <tr>
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue" >17:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">17:00-18:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">18:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">18:00-19:00</span></td>
                </c:if>
               
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">19:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">19:00-20:00</span></td>
                </c:if>
                
                <c:if test="${empty startTime}">
                  <td onclick="location.href='addReservation'"><span style="color:blue">20:00</span></td>
                </c:if>
                <c:if test="${!empty startTime}">
                  <td><span style="color:gray">20:00-21:00</span></td>
                </c:if>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
</div>

