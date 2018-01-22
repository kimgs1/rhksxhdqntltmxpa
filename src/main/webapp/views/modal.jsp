<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<div class="modal fade" id="create_NewMember_modal">
		<div class="modal-dialog">
			<div class="modal-content"  align="center">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<section class="user_pop">
        <h2>사용자정보</h2>
            <table>
                 <tr>
                    <th>사용자아이디</th>
                    <td style="border:0"></td>
                    <td><input type="text"  id="userId" name="userId" /></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="userName" name="userName"  /></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td style="border:0"></td>
                    <td><input type="password" id = "password_precheck" /></td>
                </tr>
                <tr>
                    <th>비밀번호 재확인</th>
                    <td style="border:0"></td>
                    <td><input type="password" id="password" name="password"/></td>
                </tr>
                <tr>
                    <th>e-Mail 주소</th>
                    <td style="border:0"></td>
                    <td><input type="email"  id="email" name="email"/></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="address" name="address"/></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="phone" name="phone"  /></td>
                </tr>
                <tr>
                    <th>핸드폰</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="mobile" name="mobile" /></td>
                </tr>
                
                <tr></tr>
                <tr>
                     <td style="border:0"><input type="button" onclick="newMemberSaveOnclick()" value="확인" /></td>
                    <td style="border:0"></td>
                    <td style="border:0"><input type="button" onclick="newMemberSaveCancelOnclick()"value="취소" /></td>
                </tr>
            </table>
    </section>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<div class="modal fade" id="create_bulletine_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button"  class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12">
							<div class="col-sm-1">title</div>
							<input id="cb_title" name="cb_title" class="col-sm-9">
						</div>

						<div class="col-sm-12">
							<div class="col-sm-1">content</div>
							<input type="text" id="cb_contents" name="cb_content"
								class="col-sm-9">
						</div>
						<button type="button" onclick="newBulletineSave()">저장 </button>
					</div>

				</div>

			</div>
		</div>
	</div>



	<div class="modal fade" id="view_bulletine_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- remote ajax call이 되는영역 -->
				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12">
							<div class="col-sm-1">title</div>
							<div id="vb_title" class="col-sm-9"></div>
						</div>

						<div class="col-sm-12">
							<div class="col-sm-1">content</div>
							<div id="vb_content" class="col-sm-9"></div>
						</div>
						
						<div class="col-sm-12">
							<div class="col-sm-1">작성자</div>
							<div id="vb_regid" class="col-sm-9"></div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	
	
	
	
	

	<div class="modal fade" id="create_qna_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12">
							<div class="col-sm-1">title</div>
							<input id="cq_subject" name="cq_subject" class="col-sm-9">
						</div>

						<div class="col-sm-12">
							<div class="col-sm-1">content</div>
							<input type="text" id="cq_Content" name="cq_Content"
								class="col-sm-9">
						</div>
						<button type="button" onclick="newQNASave()">저장 </button>
					</div>

				</div>

			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="view_qna_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- remote ajax call이 되는영역 -->
				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div id="vq_id" class="col-sm-9" hidden="true"></div>
						<div class="col-sm-12">
							<div class="col-sm-1">title</div>
							<div id="vq_subject" class="col-sm-9"></div>
						</div>

						<div class="col-sm-12">
							<div class="col-sm-1">content</div>
							<div id="vq_Content" class="col-sm-9"></div>
						</div>
						
						<div class="col-sm-12">
							<div class="col-sm-1">작성자</div>
							<div id="vq_regid" class="col-sm-9"></div>
						</div>
						
						<div class="col-sm-12" >
							<input id="vq_crv_content" class="col-sm-12 btn btn-sm btn-default" style="height:200px">
							<button type="button" onclick="saveReview()">댓글저장</button>
						</div>
						
						<div class="col-sm-12" id="vq_review_list"> 
							<div hidden="true">
								<div class="col-sm-2"></div>
								<div class="col-sm-7"></div>
								<div class="col-sm-2"></div>
								<div class="col-sm-1">
									<button class="close" type="button" onclick="removeQNAReview()">x</button>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	
	
	
	
	<div class="modal fade" id="create_code_group_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button"  class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12"><div class="col-sm-3">GroupID</div><input id="cgc_GroupID" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">GroupName </div><input id="cgc_GroupName" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Remark</div><input id="cgc_Remark" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">SortKey</div><input id="cgc_SortKey" class="col-sm-9"></div>
						<button type="button" onclick="newCodeGroupSave()">저장 </button>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="delete_code_group_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="margin-top: 100px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<h4>해당 코드그룹을 삭제 하시겠습니까?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal" aria-label="Close">아니요</button>
					<button id="delete_code_groupBtn" type="button" class="btn btn-primary">삭 제</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<div class="modal fade" id="create_code_info_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button"  class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12"><div class="col-sm-3">CodeID</div><input id="cic_CodeID" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">CodeName </div><input id="cic_CodeName" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Remark</div><input id="cic_Remark" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">ExtraRate</div><input id="cic_ExtraRate" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">SortKey</div><input id="cic_SortKey" class="col-sm-9"></div>
						<button type="button" onclick="newCodeInfoSave()">저장 </button>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="delete_code_info_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="margin-top: 100px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<h4>해당 코드정보을 삭제 하시겠습니까?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal" aria-label="Close">아니요</button>
					<button id="delete_code_infoBtn" type="button" class="btn btn-primary">삭 제</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<div class="modal fade" id="delete_userinfo_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="margin-top: 100px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<h4>사용자정보를 삭제 하시겠습니까?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal" aria-label="Close">아니요</button>
					<button id="delete_userinfo_Btn" type="button" class="btn btn-primary">삭 제</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="create_Penetrationbaseinfo_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button"  class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12"><div class="col-sm-3">ManagementNo</div><input id="pbic_ManagementNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">PenetrationNo </div><input id="pbic_PenetrationNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">ManagementAreaYN</div><input id="pbic_ManagementAreaYN" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Elevation</div><input id="pbic_Elevation" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">FirePreventionAreaNo</div><input id="pbic_FirePreventionAreaNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">InspectionRoomNo</div><input id="pbic_InspectionRoomNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">BackRoomNo</div><input id="pbic_BackRoomNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">PenetrationForm</div><input id="pbic_PenetrationForm" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Wall_FloorNo</div><input id="pbic_Wall_FloorNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">FirewallYN</div><input id="pbic_FirewallYN" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">WallMeterial</div><input id="pbic_WallMeterial" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">WallThickness</div><input id="pbic_WallThickness" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">FrontPicNo</div><input id="pbic_FrontPicNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">BackPicNo</div><input id="pbic_BackPicNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">ReferenceFloorPlanNo</div><input id="pbic_ReferenceFloorPlanNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">LocationFloorPlanNo</div><input id="pbic_LocationFloorPlanNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">SealDetailDWG</div><input id="pbic_SealDetailDWG" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">EL</div><input id="pbic_EL" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Diameter</div><input id="pbic_Diameter" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Height</div><input id="pbic_Height" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Length</div><input id="pbic_Length" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">PenetrationType</div><input id="pbic_PenetrationType" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">MaximumFreeArea</div><input id="pbic_MaximumFreeArea" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Register</div><input id="pbic_Register" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Reviewer</div><input id="pbic_Reviewer" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Checker</div><input id="pbic_Checker" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">SpecialNote</div><input id="pbic_SpecialNote" class="col-sm-9"></div>
						<button type="button" onclick="newPenetrationbaseinfoSave()">저장 </button>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="create_Penetrationinfo_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 750px; margin-left: 100px;">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
					<div class="row">
						<div class="col-sm-12"><div class="col-sm-3">ManagementNo</div><input id="pic_ManagementNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">PenetrationNo</div><input id="pic_PenetrationNo" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">matter</div><input id="pic_matter" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Pipe</div><input id="pic_Pipe" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Duct</div><input id="pic_Duct" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">SectionTube</div><input id="pic_SectionTube" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Conduit</div><input id="pic_Conduit" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Cable</div><input id="pic_Cable" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Tray</div><input id="pic_Tray" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">CoverTray</div><input id="pic_CoverTray" class="col-sm-9"></div>
						<div class="col-sm-12"><div class="col-sm-3">Etc</div><input id="pic_Etc" class="col-sm-9"></div>
						<button type="button" onclick="newPenetrationinfoSave()">저장 </button>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<div class="modal fade" id="create_Penetrationinspect_modal" style="padding-right: 16px;">
		<div class="modal-dialog modal-lg" style="min-width: 90%">
			<div class="modal-content" style="width:1000px; margin-left:0px">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
	
				<table class="inspectTable" style="width:950px">
				<tr>
					<th colspan="12">● 점검정보 </th>
					</tr>
				
					<tr>
						<th style="width: 13%">점검차수</th>
						
						<td style="width: 37%"></td>
						<th style="width: 13%">점검주기</th>
						<td style="width: 37%"></td>
					</tr>
					<tr>
						<th>점검일</th>
						
						<td></td>
						<th>판정</th>
						<td></td>
					</tr>
					<tr>
						<th>판단사유</th>
						
						<td colspan="3"></td>
					</tr>
					<tr>
						<th>정면사진 번호</th>
						
						<td></td>
						<th>이면사진 번호</th>
						<td></td>
					</tr>
					<tr>
						<th>정면사진</th>
						
						<td>
							<img id="frontImg" src="images/default-img.png" style="width:294px;height:210px">
							<form id="uploadPicFront" action="#" enctype="multipart/form-data">
								<input id="frontImgName" name="ImgName" hidden="true" value="front">
								<input type="file" id="uploadFileFront" name="uploadFile" onchange="ajaxFileUploadFront()" />  
							</form>
						</td>
						<th>이면사진</th>
						<td>
							<img id="backImg" src="images/default-img.png" style="width:294px;height:210px">
							<form id="uploadPicBack" action="#" enctype="multipart/form-data">
								<input id="backImgName" name="ImgName" hidden="true" value="back">
								<input type="file" id="uploadFileBack" name="uploadFile" onchange="ajaxFileUploadBack()" />  
							</form>
						</td>
					</tr>
					<tr>
						<th>보수일자</th>
						
						<td></td>
						<th>설계변경서번호</th>
						<td></td>
					</tr><tr>
						<th >보수내용</th>
						
						<td colspan="3"></td>
					</tr>
					
			</table>
					
				</div>
				
				<div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">저장</button>
              </div>
			</div>
		</div>
	</div>
	
	
	