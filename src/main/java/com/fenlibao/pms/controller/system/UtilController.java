package com.fenlibao.pms.controller.system;

import cn.hutool.core.util.IdUtil;
import com.fenlibao.base.dto.Response;
import com.fenlibao.base.dto.UploadImageReq;
import com.fenlibao.common.core.Constants;
import com.fenlibao.marketing.dto.req.publicize.article.ArticleGetListReq;
import com.fenlibao.marketing.dto.resp.publicize.ArticleListRespBody;
import com.fenlibao.pms.common.http.QiniuFileUpload;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author WangBoRan
 * @date 2019/1/24
 */
@Slf4j
@RestController
@RequestMapping("/util")
@Api(tags = {"工具接口"})
public class UtilController {


    @ApiOperation("文章列表")
    @PostMapping("/uploadImage")
    @ApiResponse(code = 200, message = "请求成功")
    public Response uploadImage(@RequestBody @Valid UploadImageReq uploadImageReq) {
        uploadImageReq.getImageBases().forEach(imageBase -> QiniuFileUpload.putBaes64(imageBase,
                IdUtil.fastSimpleUUID() + Constants.IMAGE_TYPE_JPG));
        return Response.ok("上传成功");
    }

}
