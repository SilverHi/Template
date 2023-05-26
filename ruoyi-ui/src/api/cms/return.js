import request from '@/utils/request'

// 查询借还管理列表
export function listReturn(query) {
  return request({
    url: '/cms/return/list',
    method: 'get',
    params: query
  })
}

// 查询借还管理详细
export function getReturn(brId) {
  return request({
    url: '/cms/return/' + brId,
    method: 'get'
  })
}

// 新增借还管理
export function addReturn(data) {
  return request({
    url: '/cms/return',
    method: 'post',
    data: data
  })
}

// 修改借还管理
export function updateReturn(data) {
  return request({
    url: '/cms/return',
    method: 'put',
    data: data
  })
}

// 删除借还管理
export function delReturn(brId) {
  return request({
    url: '/cms/return/' + brId,
    method: 'delete'
  })
}
