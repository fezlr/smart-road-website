const modal = new bootstrap.Modal(document.getElementById('transportModal'));

function openCreateModal() {
    document.getElementById('transportId').value = '';
    document.getElementById('transportNumber').value = '';
    document.getElementById('transportType').value = '';
    document.getElementById('transportRoute').value = '';
    document.getElementById('transportCapacity').value = '';
    modal.show();
}

function openEditModal(btn) {
    document.getElementById('transportId').value = btn.dataset.id || '';
    document.getElementById('transportNumber').value = btn.dataset.number || '';
    document.getElementById('transportType').value = btn.dataset.type || '';
    document.getElementById('transportRoute').value = btn.dataset.route || '';
    document.getElementById('transportCapacity').value = btn.dataset.capacity || '';
    modal.show();
}

function getValue(id) {
    const el = document.getElementById(id);
    return el && el.value !== '' ? el.value : null;
}

async function saveTransport() {
    const id = document.getElementById('transportId').value;

    const isEdit = id !== '';

    if (isEdit) {
        const data = {
            id: Number(id),
            number: getValue('transportNumber'),
            transportType: getValue('transportType'),
            route: getValue('transportRoute'),
            capacity: getValue('transportCapacity')
                ? Number(getValue('transportCapacity'))
                : null
        };

        const res = await fetch('/api/v1/transport/update', {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (res.ok) location.reload();
        else alert('Error');
        return;
    }

    const data = {
        id: null,
        number: getValue('transportNumber'),
        transportType: getValue('transportType'),
        route: getValue('transportRoute'),
        capacity: getValue('transportCapacity')
            ? Number(getValue('transportCapacity'))
            : null
    };

    const res = await fetch('/api/v1/transport/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    if (res.ok) location.reload();
    else alert('Error');
}

async function deleteTransport(btn) {
    if (!confirm('Вы уверены?')) return;

    const id = btn.dataset.id ? Number(btn.dataset.id) : null;

    const res = await fetch('/api/v1/transport/delete', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id })
    });

    if (res.ok) location.reload();
    else alert('Error');
}