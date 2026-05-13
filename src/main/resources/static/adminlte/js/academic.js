// ===== ACADEMIC HIERARCHY DATA =====
const academicData = [
  {
    id: 'ay1', code: 'NK2023-2027', name: 'Niên khóa 2023-2027', status: 'active',
    startDate: '2023-09-01', endDate: '2027-06-30',
    schoolYears: [
      {
        id: 'sy1', code: 'K23', name: 'Khóa K23 (2023-2027)', status: 'active',
        years: [
          {
            id: 'yr1', name: '2023-2024', status: 'completed',
            semesters: [
              { id: 'sem1', name: 'Học kỳ 1 (2023-2024)', code: 'HK1-2023', start: '2023-09-01', end: '2024-01-15', status: 'completed',
                courseSections: [
                  { id: 'cs1', code: 'CS101-01', name: 'Nhập môn CNTT - Nhóm 1', type: 'Lý thuyết', maxStudents: 60, enrolled: 55, status: 'closed',
                    students: [ {name:'Nguyễn Văn A', mssv:'SV001', status:'completed'}, {name:'Trần Thị B', mssv:'SV002', status:'completed'}, {name:'Lê Văn C', mssv:'SV003', status:'completed'} ],
                    lecturers: [ {name:'TS. Nguyễn Minh Đức', role:'Giảng viên chính', status:'active'} ]
                  },
                  { id: 'cs2', code: 'CS102-01', name: 'Toán cao cấp 1 - Nhóm 1', type: 'Lý thuyết', maxStudents: 50, enrolled: 48, status: 'closed',
                    students: [ {name:'Phạm Văn D', mssv:'SV004', status:'completed'}, {name:'Hoàng Thị E', mssv:'SV005', status:'completed'} ],
                    lecturers: [ {name:'PGS.TS. Trần Văn Hùng', role:'Giảng viên chính', status:'active'}, {name:'ThS. Lê Thị Mai', role:'Giảng viên phụ', status:'active'} ]
                  }
                ]
              },
              { id: 'sem2', name: 'Học kỳ 2 (2023-2024)', code: 'HK2-2024', start: '2024-02-01', end: '2024-06-15', status: 'completed',
                courseSections: [
                  { id: 'cs3', code: 'CS201-01', name: 'Lập trình C++ - Nhóm 1', type: 'Thực hành', maxStudents: 40, enrolled: 38, status: 'closed',
                    students: [ {name:'Nguyễn Văn A', mssv:'SV001', status:'completed'}, {name:'Trần Thị B', mssv:'SV002', status:'dropped'} ],
                    lecturers: [ {name:'TS. Phạm Quốc Cường', role:'Giảng viên chính', status:'active'} ]
                  }
                ]
              }
            ]
          },
          {
            id: 'yr2', name: '2024-2025', status: 'active',
            semesters: [
              { id: 'sem3', name: 'Học kỳ 1 (2024-2025)', code: 'HK1-2024', start: '2024-09-01', end: '2025-01-15', status: 'completed',
                courseSections: [
                  { id: 'cs4', code: 'CS301-01', name: 'Cấu trúc dữ liệu - Nhóm 1', type: 'Lý thuyết', maxStudents: 55, enrolled: 50, status: 'closed',
                    students: [ {name:'Nguyễn Văn A', mssv:'SV001', status:'completed'} ],
                    lecturers: [ {name:'TS. Nguyễn Minh Đức', role:'Giảng viên chính', status:'active'} ]
                  }
                ]
              },
              { id: 'sem4', name: 'Học kỳ 2 (2024-2025)', code: 'HK2-2025', start: '2025-02-01', end: '2025-06-15', status: 'active',
                courseSections: [
                  { id: 'cs5', code: 'CS302-01', name: 'Lập trình Java - Nhóm 1', type: 'Lý thuyết', maxStudents: 50, enrolled: 45, status: 'open',
                    students: [ {name:'Nguyễn Văn A', mssv:'SV001', status:'studying'}, {name:'Lê Văn C', mssv:'SV003', status:'studying'} ],
                    lecturers: [ {name:'TS. Phạm Quốc Cường', role:'Giảng viên chính', status:'active'}, {name:'ThS. Ngô Thanh Tùng', role:'Giảng viên phụ', status:'active'} ]
                  },
                  { id: 'cs6', code: 'CS303-01', name: 'Cơ sở dữ liệu - Nhóm 1', type: 'Thực hành', maxStudents: 40, enrolled: 35, status: 'open',
                    students: [ {name:'Trần Thị B', mssv:'SV002', status:'studying'} ],
                    lecturers: [ {name:'PGS.TS. Trần Văn Hùng', role:'Giảng viên chính', status:'active'} ]
                  }
                ]
              }
            ]
          },
          {
            id: 'yr3', name: '2025-2026', status: 'upcoming',
            semesters: [
              { id: 'sem5', name: 'Học kỳ 1 (2025-2026)', code: 'HK1-2025', start: '2025-09-01', end: '2026-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem6', name: 'Học kỳ 2 (2025-2026)', code: 'HK2-2026', start: '2026-02-01', end: '2026-06-15', status: 'upcoming', courseSections: [] }
            ]
          },
          {
            id: 'yr4', name: '2026-2027', status: 'upcoming',
            semesters: [
              { id: 'sem7', name: 'Học kỳ 1 (2026-2027)', code: 'HK1-2026', start: '2026-09-01', end: '2027-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem8', name: 'Học kỳ 2 (2026-2027)', code: 'HK2-2027', start: '2027-02-01', end: '2027-06-15', status: 'upcoming', courseSections: [] }
            ]
          }
        ]
      }
    ]
  },
  {
    id: 'ay2', code: 'NK2024-2029', name: 'Niên khóa 2024-2029', status: 'active',
    startDate: '2024-09-01', endDate: '2029-06-30',
    schoolYears: [
      {
        id: 'sy2', code: 'K24', name: 'Khóa K24 (2024-2029)', status: 'active',
        years: [
          {
            id: 'yr5', name: '2024-2025', status: 'active',
            semesters: [
              { id: 'sem9', name: 'Học kỳ 1 (2024-2025)', code: 'HK1-K24-2024', start: '2024-09-01', end: '2025-01-15', status: 'completed',
                courseSections: [
                  { id: 'cs7', code: 'CS101-K24', name: 'Nhập môn CNTT - K24', type: 'Lý thuyết', maxStudents: 65, enrolled: 60, status: 'closed',
                    students: [ {name:'Võ Thị F', mssv:'SV006', status:'completed'}, {name:'Đặng Văn G', mssv:'SV007', status:'completed'}, {name:'Bùi Thị H', mssv:'SV008', status:'completed'} ],
                    lecturers: [ {name:'TS. Nguyễn Minh Đức', role:'Giảng viên chính', status:'active'} ]
                  }
                ]
              },
              { id: 'sem10', name: 'Học kỳ 2 (2024-2025)', code: 'HK2-K24-2025', start: '2025-02-01', end: '2025-06-15', status: 'active',
                courseSections: [
                  { id: 'cs8', code: 'CS102-K24', name: 'Toán cao cấp 1 - K24', type: 'Lý thuyết', maxStudents: 60, enrolled: 55, status: 'open',
                    students: [ {name:'Võ Thị F', mssv:'SV006', status:'studying'}, {name:'Đặng Văn G', mssv:'SV007', status:'studying'} ],
                    lecturers: [ {name:'PGS.TS. Trần Văn Hùng', role:'Giảng viên chính', status:'active'}, {name:'ThS. Lê Thị Mai', role:'Giảng viên phụ', status:'active'} ]
                  }
                ]
              }
            ]
          },
          {
            id: 'yr6', name: '2025-2026', status: 'upcoming',
            semesters: [
              { id: 'sem11', name: 'Học kỳ 1 (2025-2026)', code: 'HK1-K24-2025', start: '2025-09-01', end: '2026-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem12', name: 'Học kỳ 2 (2025-2026)', code: 'HK2-K24-2026', start: '2026-02-01', end: '2026-06-15', status: 'upcoming', courseSections: [] }
            ]
          },
          {
            id: 'yr7', name: '2026-2027', status: 'upcoming',
            semesters: [
              { id: 'sem13', name: 'Học kỳ 1 (2026-2027)', code: 'HK1-K24-2026', start: '2026-09-01', end: '2027-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem14', name: 'Học kỳ 2 (2026-2027)', code: 'HK2-K24-2027', start: '2027-02-01', end: '2027-06-15', status: 'upcoming', courseSections: [] }
            ]
          },
          {
            id: 'yr8', name: '2027-2028', status: 'upcoming',
            semesters: [
              { id: 'sem15', name: 'Học kỳ 1 (2027-2028)', code: 'HK1-K24-2027', start: '2027-09-01', end: '2028-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem16', name: 'Học kỳ 2 (2027-2028)', code: 'HK2-K24-2028', start: '2028-02-01', end: '2028-06-15', status: 'upcoming', courseSections: [] }
            ]
          },
          {
            id: 'yr9', name: '2028-2029', status: 'upcoming',
            semesters: [
              { id: 'sem17', name: 'Học kỳ 1 (2028-2029)', code: 'HK1-K24-2028', start: '2028-09-01', end: '2029-01-15', status: 'upcoming', courseSections: [] },
              { id: 'sem18', name: 'Học kỳ 2 (2028-2029)', code: 'HK2-K24-2029', start: '2029-02-01', end: '2029-06-15', status: 'upcoming', courseSections: [] }
            ]
          }
        ]
      }
    ]
  }
];

// ===== BADGE HELPERS =====
function statusBadge(s) {
  const m = {active:'badge-active',completed:'badge-completed',upcoming:'badge-open',open:'badge-open',closed:'badge-closed',cancelled:'badge-cancelled',studying:'badge-studying',dropped:'badge-dropped'};
  const l = {active:'Đang hoạt động',completed:'Hoàn thành',upcoming:'Sắp tới',open:'Đang mở',closed:'Đã đóng',cancelled:'Đã hủy',studying:'Đang học',dropped:'Đã bỏ'};
  return `<span class="badge ${m[s]||'badge-closed'}">${l[s]||s}</span>`;
}
function roleBadge(r) {
  return r === 'Giảng viên chính' ? `<span class="badge badge-main">${r}</span>` : `<span class="badge badge-sub">${r}</span>`;
}

// ===== TOGGLE =====
function toggleNode(btn) {
  const content = btn.closest('.tree-node').querySelector(':scope > .tree-children');
  if (!content) return;
  const icon = btn.querySelector('.chevron');
  if (content.classList.contains('open')) {
    content.classList.remove('open');
    icon.classList.remove('bi-chevron-down');
    icon.classList.add('bi-chevron-right');
    btn.closest('.tree-node').classList.remove('expanded');
  } else {
    content.classList.add('open');
    icon.classList.remove('bi-chevron-right');
    icon.classList.add('bi-chevron-down');
    btn.closest('.tree-node').classList.add('expanded');
  }
}

// ===== RENDER =====
function renderAcademic() {
  const container = document.getElementById('academic-tree');
  let html = '';
  academicData.forEach(ay => {
    const totalSY = ay.schoolYears.length;
    html += `<div class="tree-node level-0">
      <div class="tree-header" onclick="toggleNode(this)">
        <i class="bi bi-chevron-right chevron"></i>
        <div class="node-icon level-0-icon"><i class="bi bi-calendar3"></i></div>
        <div class="node-info">
          <div class="node-title">${ay.name}</div>
          <div class="node-meta"><span class="mono">${ay.code}</span> · ${ay.startDate} → ${ay.endDate} · ${totalSY} khóa học</div>
        </div>
        ${statusBadge(ay.status)}
      </div>
      <div class="tree-children">`;

    ay.schoolYears.forEach(sy => {
      const totalYears = sy.years.length;
      html += `<div class="tree-node level-1">
        <div class="tree-header" onclick="toggleNode(this)">
          <i class="bi bi-chevron-right chevron"></i>
          <div class="node-icon level-1-icon"><i class="bi bi-calendar-range"></i></div>
          <div class="node-info">
            <div class="node-title">${sy.name}</div>
            <div class="node-meta"><span class="mono">${sy.code}</span> · ${totalYears} năm học</div>
          </div>
          ${statusBadge(sy.status)}
        </div>
        <div class="tree-children">`;

      sy.years.forEach(yr => {
        html += `<div class="tree-node level-2">
          <div class="tree-header" onclick="toggleNode(this)">
            <i class="bi bi-chevron-right chevron"></i>
            <div class="node-icon level-2-icon"><i class="bi bi-calendar-event"></i></div>
            <div class="node-info">
              <div class="node-title">Năm học ${yr.name}</div>
              <div class="node-meta">${yr.semesters.length} học kỳ</div>
            </div>
            ${statusBadge(yr.status)}
          </div>
          <div class="tree-children">`;

        yr.semesters.forEach(sem => {
          const csCount = sem.courseSections.length;
          html += `<div class="tree-node level-3">
            <div class="tree-header" onclick="toggleNode(this)">
              <i class="bi bi-chevron-right chevron"></i>
              <div class="node-icon level-3-icon"><i class="bi bi-calendar2-week"></i></div>
              <div class="node-info">
                <div class="node-title">${sem.name}</div>
                <div class="node-meta"><span class="mono">${sem.code}</span> · ${sem.start} → ${sem.end} · ${csCount} lớp học phần</div>
              </div>
              ${statusBadge(sem.status)}
            </div>
            <div class="tree-children">`;

          if (csCount === 0) {
            html += `<div class="empty-leaf"><i class="bi bi-inbox"></i> Chưa có lớp học phần</div>`;
          } else {
            sem.courseSections.forEach(cs => {
              html += `<div class="tree-node level-4">
                <div class="tree-header" onclick="toggleNode(this)">
                  <i class="bi bi-chevron-right chevron"></i>
                  <div class="node-icon level-4-icon"><i class="bi bi-book"></i></div>
                  <div class="node-info">
                    <div class="node-title">${cs.name}</div>
                    <div class="node-meta"><span class="mono">${cs.code}</span> · ${cs.type} · SV: ${cs.enrolled}/${cs.maxStudents}</div>
                  </div>
                  ${statusBadge(cs.status)}
                </div>
                <div class="tree-children">`;

              // Students
              html += `<div class="detail-section">
                <div class="detail-title"><i class="bi bi-people-fill"></i> Sinh viên đăng ký (${cs.students.length})</div>
                <div class="detail-table-wrap"><table class="detail-table">
                  <thead><tr><th>MSSV</th><th>Họ tên</th><th>Trạng thái</th></tr></thead><tbody>`;
              if (cs.students.length === 0) {
                html += `<tr><td colspan="3" style="text-align:center;color:var(--text-muted)">Chưa có sinh viên</td></tr>`;
              } else {
                cs.students.forEach(st => {
                  html += `<tr><td class="mono">${st.mssv}</td><td>${st.name}</td><td>${statusBadge(st.status)}</td></tr>`;
                });
              }
              html += `</tbody></table></div></div>`;

              // Lecturers
              html += `<div class="detail-section">
                <div class="detail-title"><i class="bi bi-person-workspace"></i> Giảng viên phân công (${cs.lecturers.length})</div>
                <div class="detail-table-wrap"><table class="detail-table">
                  <thead><tr><th>Giảng viên</th><th>Vai trò</th><th>Trạng thái</th></tr></thead><tbody>`;
              if (cs.lecturers.length === 0) {
                html += `<tr><td colspan="3" style="text-align:center;color:var(--text-muted)">Chưa phân công</td></tr>`;
              } else {
                cs.lecturers.forEach(lc => {
                  html += `<tr><td>${lc.name}</td><td>${roleBadge(lc.role)}</td><td>${statusBadge(lc.status)}</td></tr>`;
                });
              }
              html += `</tbody></table></div></div>`;

              html += `</div></div>`; // close tree-children, tree-node level-4
            });
          }
          html += `</div></div>`; // close tree-children, tree-node level-3
        });
        html += `</div></div>`; // close tree-children, tree-node level-2
      });
      html += `</div></div>`; // close tree-children, tree-node level-1
    });
    html += `</div></div>`; // close tree-children, tree-node level-0
  });
  container.innerHTML = html;
}

// ===== EXPAND/COLLAPSE ALL =====
function expandAll() {
  document.querySelectorAll('.tree-children').forEach(c => c.classList.add('open'));
  document.querySelectorAll('.chevron').forEach(c => { c.classList.remove('bi-chevron-right'); c.classList.add('bi-chevron-down'); });
  document.querySelectorAll('.tree-node').forEach(n => n.classList.add('expanded'));
}
function collapseAll() {
  document.querySelectorAll('.tree-children').forEach(c => c.classList.remove('open'));
  document.querySelectorAll('.chevron').forEach(c => { c.classList.remove('bi-chevron-down'); c.classList.add('bi-chevron-right'); });
  document.querySelectorAll('.tree-node').forEach(n => n.classList.remove('expanded'));
}

document.addEventListener('DOMContentLoaded', renderAcademic);
