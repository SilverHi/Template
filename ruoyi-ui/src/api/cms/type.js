import request from '@/utils/request'

// 查询vcd类型管理列表
export function listType(query) {
  return request({
    url: '/cms/type/list',
    method: 'get',
    params: query
  })
}

// 查询vcd类型管理详细
export function getType(typeId) {
  return request({
    url: '/cms/type/' + typeId,
    method: 'get'
  })
}

// 新增vcd类型管理
export function addType(data) {
  return request({
    url: '/cms/type',
    method: 'post',
    data: data
  })
}

// 修改vcd类型管理
export function updateType(data) {
  return request({
    url: '/cms/type',
    method: 'put',
    data: data
  })
}

// 删除vcd类型管理
export function delType(typeId) {
  return request({
    url: '/cms/type/' + typeId,
    method: 'delete'
  })
}
