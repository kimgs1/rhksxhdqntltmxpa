<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<div class="modal fade" id="create_NewMember_modal">
		<div class="modal-dialog">
			<div class="modal-content"  style="width:600px" align="center">

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
                    <th>접속허용IP주소</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="ip" name="ip"/></td>
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
	
	
	<div class="modal fade" id="edit_NewMember_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width:600px" align="center">

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
                    <td><input type="text"  id="e_userId" name="userId" /></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="e_userName" name="userName"  /></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td style="border:0"></td>
                    <td><input type="password" id = "e_password_precheck" /></td>
                </tr>
                <tr>
                    <th>비밀번호 재확인</th>
                    <td style="border:0"></td>
                    <td><input type="password" id="e_password" name="password"/></td>
                </tr>
                <tr>
                    <th>e-Mail 주소</th>
                    <td style="border:0"></td>
                    <td><input type="email"  id="e_email" name="email"/></td>
                </tr>
                <tr>
                    <th>접속허용IP주소</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="e_ip" name="ip"/></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="e_phone" name="phone"  /></td>
                </tr>
                <tr>
                    <th>핸드폰</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="e_mobile" name="mobile" /></td>
                </tr>
                
                <tr></tr>
                <tr>
                     <td style="border:0"><input type="button" onclick="editMemberSaveOnclick()" value="확인" /></td>
                    <td style="border:0"></td>
                    <td style="border:0"><input type="button" onclick="editMemberSaveCancelOnclick()"value="취소" /></td>
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
	
	
	
	
	
	<div class="modal fade" id="pie_Penetrationinspect_modal" style="padding-right: 16px;">
		<div class="modal-dialog modal-lg" style="min-width: 90%">
			<div class="modal-content" style="width:1000px; margin-left:0px">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
				<input id="pie_ManagementNo" hidden="true">
				<input id="pie_PenetrationNo" hidden="true">
				<table class="inspectTable" style="width:950px">
				<tr>
					<th colspan="12">● 점검정보 </th>
					</tr>
				
					<tr>
						<th style="width: 13%">점검주기</th>
						<td style="width: 37%"  >
							<input id="pie_InspectSeq" style="width:100%">
						</td>
						<th style="width: 13%">점검차수</th>
						
						<td style="width: 37%">
							<input id="pie_InspectionInterval" style="width:100%" disabled="disabled">
						</td>
					</tr>
					<tr>
						<th>점검일</th>
						<td>
							<input id="pie_InspectDate" style="width:100%">
						</td>
						<th>판정</th>
						<td>
							<input id="pie_Judgment" style="width:100%">
						</td>
					</tr>
					<tr>
						<th>판단사유</th>
						<td colspan="3" >
							<input id="pie_JudgementReason" style="width:100%">
						</td>
					</tr>
					<tr>
						<th>정면사진 번호</th>
						
						<td>
							<input id="pie_FrontPicNo" style="width:100%" disabled="disabled">
						</td>
						<th>이면사진 번호</th>
						<td>
							<input id="pie_BackPicNo" style="width:100%" disabled="disabled">
						</td>
					</tr>
					<tr>
						<th>정면사진</th>
						
						<td>
							<img id="pie_frontImg" src="images/default-img.png" onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'" style="width:294px;height:210px">
							<form id="pie_uploadPicFront" action="#" enctype="multipart/form-data">
								<input id="pie_frontImgName" name="ImgName" hidden="true" value="front">
								<input type="file" id="pie_uploadFileFront" name="uploadFile" onchange="pie_ajaxFileUploadFront(this)" />  
							</form>
						</td>
						<th>이면사진</th>
						<td>
							<img id="pie_backImg" src="images/default-img.png" onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'"  style="width:294px;height:210px">
							<form id="pie_uploadPicBack" action="#" enctype="multipart/form-data">
								<input id="pie_backImgName" name="ImgName" hidden="true" value="back">
								<input type="file" id="pie_uploadFileBack" name="uploadFile" onchange="pie_ajaxFileUploadBack(this)" />  
							</form>
						</td>
					</tr>
					<tr>
						<th>보수일자</th>
						
						<td>
							<input id="pie_ImproveDate" style="width:100%">
						</td>
						<th>설계변경서번호</th>
						<td>
							<input id="pie_DesignChangeNo" style="width:100%">
						</td>
					</tr>
					<tr>
						<th >보수담당자</th>
						
						<td>
							<input id="pie_ImproveMember" style="width:100%">
						</td>
					</tr>
					<tr>
		                <th>밀폐재 시공상태</th>
						<td><input id="pie_SealantConditionState_name" style="width:100%" value=""></td>
						
		                <td colspan="2">
		                	<div class="row">
			                	<div id="pie_SealantConditionState_tag" class="col-sm-4"></div> 
			                	<div class="col-sm-1">
										<input onclick="pie_SealantConditionStateAdd()"
											style="width: 60px; cursor:pointer; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
											type="button" value="추가">
								</div>
		                	</div>
		                </td>
					</tr>
					<tr>
						<th >보수내용</th>
						
						<td colspan="3">
							<input id="pie_ImproveNote" style="width:100%">
						</td>
					</tr>
					
			</table>
					
				</div>
				
				<div class="modal-footer">
                <button type="button" class="btn btn-primary" style="cursor:pointer;"  onclick="pie_updateInspectInfoSave()">저장</button>
              </div>
			</div>
		</div>
	</div>
	
	
	
	<div class="modal fade" id="pic_Penetrationinspect_modal" style="padding-right: 16px;">
		<div class="modal-dialog modal-lg" style="min-width: 90%">
			<div class="modal-content" style="width:1000px; margin-left:0px">

				<!-- header -->
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal">×</button>
				</div>
				<!-- body -->
				<div class="modal-body" align="center">
				<input id="pic_ManagementNo" hidden="true">
				<input id="pic_PenetrationNo" hidden="true">
				<table class="inspectTable" style="width:950px">
				<tr>
					<th colspan="12">● 점검정보 </th>
					</tr>
				
					<tr>
						<th style="width: 13%">점검주기</th>
						<td style="width: 37%"  >
							<input id="pic_InspectSeq" style="width:100%">
						</td>
						<th style="width: 13%">점검차수 *</th>
						
						<td style="width: 37%">
							<input id="pic_InspectionInterval" style="width:100%">
						</td>
					</tr>
					<tr>
						<th>점검일</th>
						<td>
							<input id="pic_InspectDate" style="width:100%">
						</td>
						<th>판정</th>
						<td>
							<input id="pic_Judgment" style="width:100%">
						</td>
					</tr>
					<tr>
						<th>판단사유</th>
						<td colspan="3" >
							<input id="pic_JudgementReason" style="width:100%">
						</td>
					</tr>
					<tr>
						<th>정면사진 번호</th>
						
						<td>
							<input id="pic_FrontPicNo" style="width:100%" disabled="disabled">
						</td>
						<th>이면사진 번호</th>
						<td>
							<input id="pic_BackPicNo" style="width:100%" disabled="disabled">
						</td>
					</tr>
					<tr>
						<th>정면사진</th>
						
						<td>
							<img id="pic_frontImg" src="images/default-img.png" onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'" style="width:294px;height:210px">
							<form id="pic_uploadPicFront" action="#" enctype="multipart/form-data">
								<input id="pic_frontImgName" name="ImgName" hidden="true" value="front">
								<input type="file" id="pic_uploadFileFront" name="uploadFile" onchange="pic_ajaxFileUploadFront(this)" />  
							</form>
						</td>
						<th>이면사진</th>
						<td>
							<img id="pic_backImg" src="images/default-img.png" onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'"  style="width:294px;height:210px">
							<form id="pic_uploadPicBack" action="#" enctype="multipart/form-data">
								<input id="pic_backImgName" name="ImgName" hidden="true" value="back">
								<input type="file" id="pic_uploadFileBack" name="uploadFile" onchange="pic_ajaxFileUploadBack(this)" />  
							</form>
						</td>
					</tr>
					<tr>
						<th>보수일자</th>
						
						<td>
							<input id="pic_ImproveDate" style="width:100%">
						</td>
						<th>설계변경서번호</th>
						<td>
							<input id="pic_DesignChangeNo" style="width:100%">
						</td>
					</tr>
					<tr>
						<th >보수담당자</th>
						
						<td>
							<input id="pic_ImproveMember" style="width:100%">
						</td>
					</tr>
					<tr>
		                <th>밀폐재 시공상태</th>
						<td><input id="pic_SealantConditionState_name" style="width:100%" value=""></td>
						
		                <td colspan="2">
		                	<div class="row">
			                	<div id="pic_SealantConditionState_tag" class="col-sm-4"></div> 
			                	<div class="col-sm-1">
										<input onclick="pic_SealantConditionStateAdd()"
											style="width: 60px; cursor:pointer; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
											type="button" value="추가">
								</div>
		                	</div>
		                </td>
					</tr>
					<tr>
						<th >보수내용</th>
						
						<td colspan="3">
							<input id="pic_ImproveNote" style="width:100%">
						</td>
					</tr>
					
			</table>
					
				</div>
				
				<div class="modal-footer">
                <button type="button" class="btn btn-primary" style="cursor:pointer;" onclick="pic_updateInspectInfoSave()">저장</button>
              </div>
			</div>
		</div>
	</div>
	
	
	
	
	<div class="modal fade" id="excel_modal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 360px; margin-left: 100px;">
				<div class="modal-header">
					<h4 class="modal-title">엑셀 데이터 저장</h4>
				</div>
				<div class="modal-body" align="center">
					<label class="control-label" style="text-align: left">엑셀
						데이터를 생성하는 중입니다. <br> 검색조건에 따라 시간이 많이 걸릴 수도 있습니다.</label><br> <br> <img
						src="./img/loading_ani.gif" style="width: 100%">
				</div>
			</div>
		</div>
	</div>
	
	
	