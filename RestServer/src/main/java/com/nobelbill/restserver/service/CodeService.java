package com.nobelbill.restserver.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestParam;

import com.nobelbill.restserver.dao.CommonDao;
import com.nobelbill.restserver.dataset.Code;

@Path("/test")
public class CodeService {

	private CommonDao commonDao;

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create() {
		Code info = new Code();
		return Response.status(200).entity(info).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{mainCode}")
	public Code get(@RequestParam("mainCode") String main_code) {
		return commonDao.selectCode(main_code);
	}
}
