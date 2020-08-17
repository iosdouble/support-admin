import request from '@/utils/request'
import da from "element-ui/src/locale/lang/da";

// 查询微信卡券基础信息必填信息 列表
export function listInfo(query) {
  return request({
    url: '/system/info/list',
    method: 'get',
    params: query
  })
}

// 查询微信卡券基础信息必填信息 详细
export function getInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'get'
  })
}

// 新增微信卡券基础信息必填信息
export function addInfo(data) {
  return request({
    url: '/system/info',
    method: 'post',
    data: data
  })
}

// 修改微信卡券基础信息必填信息
export function updateInfo(data) {
  return request({
    url: '/system/info',
    method: 'put',
    data: data
  })
}

// 删除微信卡券基础信息必填信息
export function delInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'delete'
  })
}

// 导出微信卡券基础信息必填信息
export function exportInfo(query) {
  return request({
    url: '/system/info/export',
    method: 'get',
    params: query
  })
}

export function createCard(data) {
  return request({
    url: '/kaqu/createCard',
    method: 'post',
    data: data
  })
}

export function getInfoList(data) {
  return request({
    url: '/kaqu/list',
    method: 'get',
  })
}
