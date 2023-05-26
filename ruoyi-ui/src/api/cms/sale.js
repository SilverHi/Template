import request from '@/utils/request'

// 查询零售管理列表
export function listSale(query) {
  return request({
    url: '/cms/sale/list',
    method: 'get',
    params: query
  })
}

// 查询零售管理详细
export function getSale(saleId) {
  return request({
    url: '/cms/sale/' + saleId,
    method: 'get'
  })
}

// 新增零售管理
export function addSale(data) {
  return request({
    url: '/cms/sale',
    method: 'post',
    data: data
  })
}

// 修改零售管理
export function updateSale(data) {
  return request({
    url: '/cms/sale',
    method: 'put',
    data: data
  })
}

// 删除零售管理
export function delSale(saleId) {
  return request({
    url: '/cms/sale/' + saleId,
    method: 'delete'
  })
}
