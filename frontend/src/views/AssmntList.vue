<template>
  <div class="wrapper">
    <div class="container content">
      <!--Table Bordered-->
      <div class="panel panel-grey margin-bottom-40">
        <div class="panel-heading">
          <table>
            <tr>
              <td> 
                <h3 class="panel-title">
                  <i class="fa fa-globe"></i>위험성평가서
                </h3>
              </td>
              <td>
                <button class="btn btn-warning btn-xs" @click="addRow">
                  <i class="fa fa-pencil"></i> 행추가
                </button>
                <button class="btn btn-warning btn-xs" @click="save">
                  <i class="fa fa-pencil"></i> 저장
                </button>
              </td>
            </tr>
          </table>
        </div>
        <div class="panel-body" style="height: 200px; overflow-y: auto">
          <table contenteditable class="table table-bordered">
            <thead>
              <tr>
                <th>NO</th>
                <th>상태</th>
                <th>월</th>
                <th>회차</th>
                <th>시작일자</th>
                <th>종료일자</th>
                <th>기업/협력사</th>
                <th>대공종</th>
                <th>현장소장의견</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(row, index) in assmntLst" v-bind:key="row.REGIS_SEQ">
                <td>{{index+1}}</td>
                <td>{{row.check_TF}}</td>
                <td><input class="form-control" v-model="row.stan_MONTH" /></td> 
                <td><input class="form-control" v-model="row.stan_DEGREE" /></td>
                <td><input class="form-control" v-model="row.mng_DATE_FROM" /></td>
                <td><input class="form-control" v-model="row.mng_DATE_TO" /></td>
                <td><input class="form-control" v-model="row.r_COMPANY_ID" /></td>
                <td><input class="form-control" v-model="row.main_CNSTRCT" /></td>
                <td><input class="form-control" v-model="row.apprv_CMT" /></td>
                <!-- 
                <td>
                  <a
                    th:href="@{/sfas/AssmntDtlList(REGIS_SEQ=${AssmntLst.REGIS_SEQ})}"
                    th:text="${AssmntLst.R_COMPANY_ID}"
                  ></a>
                </td>
                -->
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <!-- 상세내용 -->
      <div class="panel panel-grey margin-bottom-40">
        <div class="panel-heading">
          <table>
            <tr>
              <td>
                <h3 class="panel-title">
                  <i class="fa fa-globe"></i>위험성평가서별 내용
                </h3>
              </td>
            </tr>
          </table>
        </div>
        <div class="panel-body" style="height: 200px; overflow-y: auto">
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>NO</th>
                <th>First Name</th>
                <th class="hidden-sm">Last Name</th>
                <th>Username</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>Mark</td>
                <td class="hidden-sm">Otto</td>
                <td>@mdo</td>
                <td>
                  <button class="btn btn-danger btn-xs">
                    <i class="fa fa-trash-o"></i> Delete
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="row">
        <!-- 평가의견 -->
        <div class="col-md-6">
          <div class="panel panel-grey margin-bottom-40">
            <div class="panel-heading">
              <table>
                <tr>
                  <td>
                    <h3 class="panel-title">
                      <i class="fa fa-globe"></i>위험성평가서별 내용별
                      공사담당/팀장 검토의견
                    </h3>
                  </td>
                </tr>
              </table>
            </div>
            <div class="panel-body" style="height: 200px; overflow-y: auto">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>NO</th>
                    <th>First Name</th>
                    <th class="hidden-sm">Last Name</th>
                    <th>Username</th>
                    <th>Status</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td class="hidden-sm">Otto</td>
                    <td>@mdo</td>
                    <td>
                      <button class="btn btn-danger btn-xs">
                        <i class="fa fa-trash-o"></i> Delete
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td class="hidden-sm">Thornton</td>
                    <td>@fat</td>
                    <td>
                      <button class="btn btn-warning btn-xs">
                        <i class="fa fa-pencil"></i> Edit
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td class="hidden-sm">the Bird</td>
                    <td>@twitter</td>
                    <td>
                      <button class="btn btn-info btn-xs">
                        <i class="fa fa-share"></i> Share
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>htmlstream</td>
                    <td class="hidden-sm">Web Design</td>
                    <td>@htmlstream</td>
                    <td>
                      <button class="btn btn-success btn-xs">
                        <i class="fa fa-check"></i> Submit
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>htmlstream</td>
                    <td class="hidden-sm">Web Design</td>
                    <td>@htmlstream</td>
                    <td>
                      <button class="btn btn-success btn-xs">
                        <i class="fa fa-check"></i> Submit
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <!-- 평가의견 -->
        <div class="col-md-6">
          <div class="panel panel-grey margin-bottom-40">
            <div class="panel-heading">
              <table>
                <tr>
                  <td>
                    <h3 class="panel-title">
                      <i class="fa fa-globe"></i>위험성평가서별 내용별
                      안전관리자 검토의견
                    </h3>
                  </td>
                </tr>
              </table>
            </div>
            <div class="panel-body" style="height: 200px; overflow-y: auto">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>NO</th>
                    <th>First Name</th>
                    <th class="hidden-sm">Last Name</th>
                    <th>Username</th>
                    <th>Status</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td class="hidden-sm">Otto</td>
                    <td>@mdo</td>
                    <td>
                      <button class="btn btn-danger btn-xs">
                        <i class="fa fa-trash-o"></i> Delete
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td class="hidden-sm">Thornton</td>
                    <td>@fat</td>
                    <td>
                      <button class="btn btn-warning btn-xs">
                        <i class="fa fa-pencil"></i> Edit
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td class="hidden-sm">the Bird</td>
                    <td>@twitter</td>
                    <td>
                      <button class="btn btn-info btn-xs">
                        <i class="fa fa-share"></i> Share
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>htmlstream</td>
                    <td class="hidden-sm">Web Design</td>
                    <td>@htmlstream</td>
                    <td>
                      <button class="btn btn-success btn-xs">
                        <i class="fa fa-check"></i> Submit
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>htmlstream</td>
                    <td class="hidden-sm">Web Design</td>
                    <td>@htmlstream</td>
                    <td>
                      <button class="btn btn-success btn-xs">
                        <i class="fa fa-check"></i> Submit
                      </button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "AssmntList",
  data() {
    return {
      assmntLst: []
    }
  },
  created() {
    this.getAssmntData()
  },
  methods: {
    getAssmntData() {
      axios
        .get("http://localhost:8081/sfas/AssmntList")
        .then((response) => {
          console.log(response.data)
        
          this.assmntLst = response.data
        })
        .catch((error) => {
          console.log(error);
        })
    },
    addRow() {
      this.assmntLst.push({check_TF:"등록", COMPANY_ID:2})
    },
    save() {
      axios
        .post("http://localhost:8081/sfas/insertAssmntList", this.assmntLst)
        .then((response) => {
          console.log(response.data)
        
         // this.assmntLst = response.data
        })
        .catch((error) => {
          console.log(error);
        });
    }
  },
};
</script>
